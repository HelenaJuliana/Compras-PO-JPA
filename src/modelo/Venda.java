package modelo;
import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.type.LocalDateType;



@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cpf;
	private String nome;
	private String data;
	private double valor;

	
	@OneToMany(	mappedBy="venda",
			cascade=CascadeType.ALL, 	
			orphanRemoval=true,			//default é false
			fetch=FetchType.EAGER) 		//default é LAZY
	private List<Produto> produtos = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	

	public Venda() {

	}



	public Venda(String string, String string2, String string3, double valor) {

		this.cpf = string;
		this.nome = string2;
		this.data = string3;
		this.valor = valor;
	}

	public int getIdVenda() {
		return id;
	}

	public void setIdVenda(int idVenda) {
		this.id = idVenda;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	public void adicionar(Produto p){
		produtos.add(p);
		p.setVenda(this);
	}
	
	public void remover(Produto p){
		produtos.remove(p);
		p.setVenda(null);
	}
	public Produto localizarProduto(String nome){
		for(Produto t : produtos)
			if(t.getNome_produto().equals(nome)) 
				return t;

		return null;			
	}

	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		return result;
	}
	
	
	

	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String texto ;
		texto = "Vendas--ID=" + id + ", cpf=" + cpf + ", Data =" + data +", valor =" + valor + ", nome=" +String.format("%10s", nome);  
		texto += ", produtos: ";
		for(Produto p : produtos)
			texto+= p.getNome_produto() + ",";

		return texto;
	}
	
	

}