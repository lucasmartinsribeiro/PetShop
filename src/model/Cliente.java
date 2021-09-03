package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	private String cpf;
	
	//@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "dono")
	private List<Animal> animais;
	
	public Cliente () {
		endereco = new Endereco();
	}

	public String getEnderecoCompleto() {
		return endereco.toString();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
}
