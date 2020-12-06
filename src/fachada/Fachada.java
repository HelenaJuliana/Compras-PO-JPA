package fachada;

import java.util.Iterator;
import java.util.List;

import daojpa.*;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;



public class Fachada {
	
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOFuncionario daofuncionario = new DAOFuncionario(); 
	private static DAOVenda daovenda = new DAOVenda();
	private static DAOProduto daoproduto = new DAOProduto();


	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Cliente cadastrarCliente(String nome) throws  Exception{
		DAO.begin();	
		Cliente c = daocliente.read(nome);
		if(c != null) {
			DAO.rollback();
			throw new Exception("cliente ja cadastrado:" + nome);
		}
		c = new Cliente(nome);
		daocliente.create(c);	
		DAO.commit();
		return c;
	}


	public static Cliente alterarCliente(String nome, String novonome) throws Exception{
		DAO.begin();		
		Cliente c1 = daocliente.read(nome);	//usando  chave primaria
		if (c1==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		c1.setNome(novonome); 			
		c1=daocliente.update(c1);     	
		DAO.commit();
		return c1;
	}

	
	public static void excluirCliente(String n) throws Exception {
		DAO.begin();
		Cliente c1 = daocliente.read(n);
		if (c1==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + n);
		}
		daocliente.delete(c1);  
		DAO.commit();
	}

	public static void excluirFuncionario(String n) throws Exception {
		DAO.begin();
		Funcionario f1 = daofuncionario.read(n);
		if (f1==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + n);
		}
		daofuncionario.delete(f1);  
		DAO.commit();
	}

	public static void excluirProduto(String n) throws Exception {
		DAO.begin();
		Produto p1 = daoproduto.read(n);
		if (p1==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + n);
		}
		daoproduto.delete(p1);  
		DAO.commit();
	}


	public static void excluirVenda(String n) throws Exception {
		DAO.begin();
		Venda v1 = daovenda.read(n);
		if (v1==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + n);
		}
		daovenda.delete(v1);  
		DAO.commit();
	}


	public static List<Cliente> listarCliente(){
		return daocliente.readAll();
	}
	
	public static List<Funcionario> listarFuncionario(){
		return daofuncionario.readAll();
	}
	
	public static List<Venda> listarVenda(){
		return daovenda.readAll();
	}
	
	public static List<Produto> listarProduto(){
		return daoproduto.readAll();
	}
	
	
	public static Funcionario alterarFuncionario(String nome, String novonome) throws Exception{
		DAO.begin();		
		Funcionario p = daofuncionario.read(nome);	//usando  chave primaria
		if (p==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		p.setNome(novonome); 			
		p=daofuncionario.update(p);     	
		DAO.commit();
		return p;
	}

	public static Venda alterarVenda(String nome, String novonome) throws Exception{
		DAO.begin();		
		Venda v = daovenda.read(nome);	//usando  chave primaria
		if (v==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		v.setNome(novonome); 			
		v=daovenda.update(v);     	
		DAO.commit();
		return v;
	}
	
	public static Produto alterarProduto(String nome, String novonome) throws Exception{
		DAO.begin();		
		Produto p = daoproduto.read(nome);	//usando  chave primaria
		if (p==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		p.setNome_produto(novonome); 			
		p=daoproduto.update(p);     	
		DAO.commit();
		return p;
	}

	/**********************************************************
	 * 
	 * CONSULTAS IMPLEMENTADAS NOS DAO
	 * 
	 **********************************************************/

	public static List<Cliente> consultarCliente(String caracteres) {
		return daocliente.consultarCliente(caracteres);
	}
//	
	public static List<Funcionario> consultarFuncionario(String caracteres) {
		return daofuncionario.consultarFuncionario(caracteres);
	}
	
	public static List<Produto> consultarProduto(String caracteres) {
		return daoproduto.consultarProduto(caracteres);
	}
	

}
