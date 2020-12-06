package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Deletar {

	public Deletar(){
		try {
			Fachada.inicializar();
			Fachada.excluirCliente("paula");
			System.out.println("deletou ");
			
//			Fachada.excluirFuncionario("Clara");
//			System.out.println("deletou ");
			
//			Fachada.excluirProduto("Camisa");
//			System.out.println("deletou ");
			

			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

