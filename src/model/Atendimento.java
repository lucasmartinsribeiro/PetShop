package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Atendimento {
	
	@Id @GeneratedValue
	private Long id;
	
	private String descricao;
	private Double valor;
	
	@ManyToOne
	private Animal animalAtendido = new Animal();
	
	public Atendimento() {
		
	}

	public Atendimento(String descricao, Double valor, Animal animalAtendido) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.animalAtendido = animalAtendido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Animal getAnimalAtendido() {
		return animalAtendido;
	}

	public void setAnimalAtendido(Animal animalAtendido) {
		this.animalAtendido = animalAtendido;
	}
	
}
