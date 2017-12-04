package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id @GenerateValue
	private long id;
	
	private String nome;

	private String descricao;

	private Double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/*public String getId() {
		return id;
	}*/

	/*public void setId(String id) {
		this.id = id;
	}*/
}
