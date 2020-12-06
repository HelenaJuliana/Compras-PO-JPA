package aplicacaoConsole;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		
		try {
			Fachada.inicializar();
//			System.out.println("1.\n"+Fachada.consultarCliente("jo") );
			System.out.println("2.\n"+Fachada.consultarCliente("Pedro") );
			System.out.println("3.\n"+Fachada.consultarFuncionario("Joao Pedro") );
			System.out.println("4.\n"+Fachada.consultarProduto("Blusa") );

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

