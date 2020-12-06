package modelo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import daojpa.Trigger;

@Entity 
@EntityListeners( Trigger.class )  // CLASSE QUE IMPLEMENTA OS EVENTOS (TRIGGERS)

public class Funcionario {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cpf;
	private String nome;
	private String email;
	
	@Transient 
	private int idade;		//calculado
	@Column(columnDefinition = "DATE")	
	private LocalDate nascimento = LocalDate.of(1992,01,01);
	
	
//	@ManyToOne
//	private Venda venda;
	
	public Funcionario() {
		
	}


	public Funcionario(String cpf,String nome,int idade,String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.idade =idade;
		
	}
	

	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String texto ;
		texto = "Funcionario: CPF " + cpf + ",nome="+nome + ", email=" + email + String.format("%10s", nome);  
		texto+="----- idade="+idade;
		
		return texto;
	}

}
