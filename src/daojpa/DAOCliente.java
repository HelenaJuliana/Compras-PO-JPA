

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{

	public Cliente read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where c.nome=:n", Cliente.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Cliente> readAll(){
		TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c order by c.id", Cliente.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Cliente> consultarCliente(String caracteres) {
		TypedQuery<Cliente> q = manager.createQuery
				("select c from Cliente c where c.nome like '%"+caracteres+"%' order by c.nome",Cliente.class);
		return q.getResultList();
	}
	


	public  boolean  consutaClienteQueComprouProdutos(String nome) {
		try{
			TypedQuery<Cliente> q = manager.createQuery
					("select c from Cliente c join f.nome "
							+ "t where c.nome = :x and v.valor like :y",Cliente.class);
			q.setParameter("x", nome);
			Cliente c = q.getSingleResult();
		if (c==null)	return false;
		else			return true;
	}catch(NoResultException e){
			return false;
		}
	}
	
	
	}

	




