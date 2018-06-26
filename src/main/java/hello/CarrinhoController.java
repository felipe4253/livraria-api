package hello;

import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarrinhoController {

    @GetMapping(value= "/publico/v1/carrinho/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity buscaPorId(@PathVariable(value="id") Long id) {
        Carrinho carrinho = new Carrinho();

        Livro livro = new Livro();
        livro.setId(id);
        livro.setAutor("José Autor de teste " + id);
        livro.setTitulo("Um Livro de exemplo com o id " + id);
        livro.setPrefacio("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam lobortis eros nec mi tincidunt dignissim.");
        
        HashSet<Livro> livros = new HashSet<Livro>();
        livros.add(livro);
        
        carrinho.setLivros(livros);
        
		return ResponseEntity.ok(carrinho);
    }
    
	@PostMapping(value = "/publico/v1/carrinho/{id}/checkout", consumes = "application/json", produces = "application/json")
	public ResponseEntity checkoutCarrinho(@PathVariable(value = "id") String id) {

		RestTemplate restTemplate = new RestTemplate();
		TokenValidationResponse tokenValidationResponse = restTemplate.getForObject("http://localhost:8444/publico/v1/login/1234567890123123123", TokenValidationResponse.class);
		if (tokenValidationResponse != null && tokenValidationResponse.getValido()) {
			System.out.println(tokenValidationResponse);
			return ResponseEntity.ok("{\"result\" : \"Checkout efetuado com sucesso\"}");			
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    
}
