package hello;

public class TokenValidationResponse {
	
	private Boolean valido;

	public Boolean getValido() {
		return valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

	@Override
	public String toString() {
		return "TokenValidationResponse [valido=" + valido + "]";
	}
	
	

}
