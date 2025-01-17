package daojpa;

/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */


import java.time.LocalDate;
import java.time.Period;

import javax.persistence.PersistenceException;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

import modelo.Funcionario;

public class Trigger{  

	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		System.out.println(" @PrePersist... " + obj);

	}

	@PostPersist
	public void exibirmsg2(Object obj) {
		System.out.println(" @PostPersist... " + obj);
		if (obj instanceof Funcionario)  {
			Funcionario f = (Funcionario)obj;
			int idade = calcularIdade( f );
			f.setIdade(idade);
			System.out.println(" ***idade calculada=" +obj + "\n");
		}

	}

	@PostLoad
	public void exibirmsg3(Object obj) {
		System.out.println(" @PostLoad... " + obj);
		if (obj instanceof Funcionario)  {
			Funcionario f = (Funcionario)obj;
			int idade = calcularIdade( f );
			f.setIdade(idade);
			System.out.println(" ***idade calculada=" +obj + "\n");
		}
	}	

	@PostRemove
	public void exibirmsg4(Object obj) {
		System.out.println(" @PostRemove.... " + obj);
	}

	//============================================================
	public int calcularIdade(Funcionario p) {
		LocalDate hoje = LocalDate.now();
		Period per = Period.between(p.getNascimento(), hoje);
		int idade = per.getYears();
		return idade;
	}
}
