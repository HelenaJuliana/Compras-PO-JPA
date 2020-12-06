package modelo;

import java.beans.Transient;
import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto{

	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome_produto;
	private double preco;
	private int quant_estoq;
	private String  descricao;
	
	
	@ManyToOne
	private Venda venda;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();



	public Produto( String nome_produto, int quant_estoq, String descricao, double preco) {
		 
	       this.nome_produto = nome_produto;
	       this.quant_estoq = quant_estoq;
	       this.descricao = descricao;
	       this.preco = preco;
		
	}
	
	public Produto() {
			
		}
	
	public Produto(
			
			String nome_produto,
			double preco,
			int quant_estoq, 
			String descricao) {
		
     
       this.nome_produto = nome_produto;
       this.preco = preco;
       this.quant_estoq = quant_estoq;
       this.descricao = descricao;
	
	}


	
	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQuant_estoq() {
		return quant_estoq;
	}

	public void setQuant_estoq(int quant_estoq) {
		this.quant_estoq = quant_estoq;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void adicionar(Produto p){
		p.setId(id);
		this.produtos.add(p);

	}

	public void remover(Produto p){
		p.setNome_produto(null);
		this.produtos.remove(p);
	}
	
//	
	public Produto localizar(Integer num){
		for(Produto p : produtos) {
			if (p.getNome_produto().equals(num))
				return p;
		}
		return null;
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	
	


	public String toString() {
	
		String texto ;
		texto = "Produtos-- ID=" + id + ", Quantidade=" + quant_estoq + ", Descrição = " + descricao +",Tipo="+String.format("%5s",nome_produto);  
		texto += ", produtos: ";
		for(Produto p : produtos)
			texto+= p.getNome_produto() + ",";

		return texto;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome_produto == null) ? 0 : nome_produto.hashCode());
		return result;
	}

	

	public void setProduto(Venda venda2) {
		this.venda = venda;
	}
		
	
	
	//	--------------------RELACIONAMENTO--------------------------------
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	

}
