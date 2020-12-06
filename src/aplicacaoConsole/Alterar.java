package aplicacaoConsole;


import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;



public class Alterar {

	public Alterar(){
		try {
			Fachada.inicializar();
			
//			Cliente c1;
//			Funcionario f;
			Venda v;
			
			Produto p;
//			
//			c1 = Fachada.alterarCliente("Maria","paula");
//			System.out.println("\nCliente alterada -->"+c1);
////			
//			f = Fachada.alterarFuncionario("Maria","paula");
//			System.out.println("\nFuncionário alterado -->"+f);
//			
			v = Fachada.alterarVenda("Joao Pedro","Maria Clara");
			System.out.println("\nVenda alterada -->"+v);
//			
//			p = Fachada.alterarProduto("Camisa Branca","Blusa");
//			System.out.println("\nVenda alterada -->"+p);
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

