package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @GetMapping(value= "/publico/v1/livro/{id}", produces="application/json")
    @ResponseBody
    public ResponseEntity buscaPorId(@PathVariable(value="id") Long id) {
        Livro livro = new Livro();

        livro.setId(id);
        livro.setAutor("José Autor de teste " + id);
        livro.setTitulo("Um Livro de exemplo com o id " + id);
        livro.setPrefacio("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam lobortis eros nec mi tincidunt dignissim.");
        
		return ResponseEntity.ok(livro);
    }
    
    @PostMapping(value= "/publico/v1/livro/{isbn}/comentario", consumes="application/json", produces="application/json")
    public ResponseEntity postarComentario(@PathVariable(value="isbn") String isbn, @RequestBody Comentario comentario) {
    	
    	return ResponseEntity.ok("");
    }
    
    @GetMapping(value= "/publico/v1/livro")
    public ResponseEntity buscaPorFiltros(
    		@RequestParam(value="isbn") String isbn, 
    		@RequestParam(value="autor") String autor) {
    	
    	ArrayList<Livro> livrosEncontrados = new ArrayList<>();
    	
    	for (int i = 0; i <= 3; i++) {
    		Livro livro = new Livro();
    		
    		livro.setId(12L);
    		livro.setAutor("José Autor de teste ");
    		livro.setTitulo("Um Livro de exemplo com o id ");
    		livro.setPrefacio("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam lobortis eros nec mi tincidunt dignissim.");
    		livrosEncontrados.add(livro);
    		
    	}
        
		return ResponseEntity.ok(livrosEncontrados);
    }
}
