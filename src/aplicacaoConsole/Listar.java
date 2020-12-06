package aplicacaoConsole;


import fachada.Fachada;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;


public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();
			
			System.out.println("Listagem de cliente:");
			for(Cliente c : Fachada.listarCliente())		
				System.out.println(c);
			
			
			System.out.println("Listagem de funcinário:");
			for(Funcionario f : Fachada.listarFuncionario())		
				System.out.println(f);
			
			System.out.println("Listagem de vendas:");
			for(Venda v : Fachada.listarVenda())		
				System.out.println(v);
			
			System.out.println("Listagem de produtos:");
			for(Produto p : Fachada.listarProduto())		
				System.out.println(p);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

