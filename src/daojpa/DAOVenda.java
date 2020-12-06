package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Venda;

public class DAOVenda extends DAO<Venda> {
	
	public Venda read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Venda> q = manager.createQuery("select v from Venda v where v.nome=:n", Venda.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Venda> readAll(){
		TypedQuery<Venda> q = manager.createQuery("select v from Venda v order by v.id", Venda.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Venda> consultarVenda(String caracteres) {
		TypedQuery<Venda> q = manager.createQuery
				("select v from Venda v where v.nome like '%"+caracteres+"%' order by v.nome",Venda.class);
		return q.getResultList();
	}
	

}
