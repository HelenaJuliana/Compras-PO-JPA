package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


import modelo.Funcionario;

public class DAOFuncionario extends DAO<Funcionario>{

	public Funcionario read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Funcionario> q = manager.createQuery("select f from Funcionario f where f.nome=:n", Funcionario.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Funcionario> readAll(){
		TypedQuery<Funcionario> q = manager.createQuery("select f from Funcionario f order by f.id",Funcionario.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Funcionario> consultarFuncionario(String caracteres) {
		TypedQuery<Funcionario> q = manager.createQuery
				("select f from Funcionario f where f.nome like '%"+caracteres+"%' order by f.nome",Funcionario.class);
		return q.getResultList();
	}
		

}
