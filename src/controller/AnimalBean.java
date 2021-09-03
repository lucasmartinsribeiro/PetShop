package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Animal;
import model.Cliente;
import service.AnimalService;
import service.ClienteService;


@ViewScoped
@ManagedBean
public class AnimalBean {
	
	@EJB
	private AnimalService animalService;
	
	@EJB
	private ClienteService clienteService;
	
	private Animal animal = new Animal();
	
	private List<Animal> animais = new ArrayList<Animal>();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	private long idClienteAtual = 0L;
	
	private Boolean statusEdicao = false;
	
	@PostConstruct
	public void init() {
		listarAnimais();
		listarClientes();
		statusEdicao = false;
	}
	
	private void listarAnimais() {
		animais = animalService.listAll();
	}
	
	private void listarClientes() {
		clientes = clienteService.listAll();
	}
	
	private void processarAnimal() {
		animal = new Animal();
		idClienteAtual = 0L;
		listarAnimais();
	}
	
	public void gravarAnimal() {
		animal.getDono().setId(idClienteAtual);
		animal.setDono(clienteService.obtemPorId(idClienteAtual));
		animalService.create(animal);
		
		
		FacesContext.getCurrentInstance().
		addMessage("msg", new FacesMessage("Animal " + getAnimal().getNome() + 
				" registrado para o dono " + getAnimal().getDono().getNome() + " com sucesso!"));
		
		processarAnimal();
		
		//testando status da edicao
		//status = true;
	}
	
	public void atualizarAnimal() {
		animalService.merge(animal);
		
		FacesContext.getCurrentInstance().
		addMessage("msg", new FacesMessage("Animal " + getAnimal().getNome() + 
				" atualizado com sucesso!"));
		processarAnimal();
		
		statusEdicao = false;
	}
	
	public void carregarAnimal(Animal a) {
		setAnimal(a);
		idClienteAtual = a.getDono().getId();
		
		statusEdicao = true;
	}
	
	public void cancelar() {
		animal = new Animal();
		idClienteAtual = 0L;
		
		statusEdicao = false;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public long getIdClienteAtual() {
		return idClienteAtual;
	}

	public void setIdClienteAtual(long idClienteAtual) {
		this.idClienteAtual = idClienteAtual;
	}

	public Boolean getStatusEdicao() {
		return statusEdicao;
	}

	public void setStatusEdicao(Boolean statusEdicao) {
		this.statusEdicao = statusEdicao;
	}
	
}
