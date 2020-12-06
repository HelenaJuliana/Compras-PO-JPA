package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Produto;


public class DAOProduto extends DAO<Produto>{
	
	public Produto read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p where p.nome_produto=:n", Produto.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Produto> readAll(){
		TypedQuery<Produto> q = manager.createQuery("select p from Produto p order by p.id", Produto.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Produto> consultarProduto(String caracteres) {
		TypedQuery<Produto> q = manager.createQuery
				("select p from Produto p where p.nome_produto like '%"+caracteres+"%' order by p.nome_produto",Produto.class);
		return q.getResultList();
	}
	
	

}
