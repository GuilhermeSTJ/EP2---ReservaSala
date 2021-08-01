public class ErroSalaException extends Exception{  
	private String msg;  
	public ErroSalaException(){  
		super("Erro ao tentar reservar a sala");  
		this.msg = "Erro ao tentar reservar a sala";  
	}  
	public String getMessage(){  
		return msg;  
	}
}