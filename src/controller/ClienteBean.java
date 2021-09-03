package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Cliente;
import model.Endereco;
import service.ClienteService;
import service.EnderecoService;

@ViewScoped
@ManagedBean
public class ClienteBean {
	
	@EJB
	private ClienteService clienteService;
	
	@EJB
	private EnderecoService enderecoService;
	
	private Cliente cliente = new Cliente();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	//private Endereco endereco = new Endereco();
	
	private List<Endereco> listaEnderecos = new ArrayList<Endereco>();
	
	private Long idEnderecoAtual = 0L;
	
	private long idClienteAtual = 0L;
	
	@PostConstruct
	public void init() {
		listarClientes();
	}
	
	public void listarClientes() {
		clientes = clienteService.listAll();
	}
	
	public void gravarCliente() {
		//cliente.setEndereco(endereco);
		//enderecoService.create(cliente.getEndereco());
		//clienteService.gravarClienteComEndereco(cliente);
		
		clienteService.create(cliente);
		
		FacesContext.getCurrentInstance().
		addMessage("msg", new FacesMessage("Cliente " + getCliente().getNome() + 
				" registrado com sucesso!"));
		
		cliente = new Cliente();
		listarClientes();
	}
	
	public void carregarCliente(Cliente c) {
		//cliente = c;
		setCliente(c);
		idClienteAtual = c.getId();
	}
	
	public void cancelar() {
		cliente = new Cliente();
		listarClientes();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public Long getIdEnderecoAtual() {
		return idEnderecoAtual;
	}

	public void setIdEnderecoAtual(Long idEnderecoAtual) {
		this.idEnderecoAtual = idEnderecoAtual;
	}
	
	public long getIdClienteAtual() {
		return idClienteAtual;
	}

	public void setIdClienteAtual(long idClienteAtual) {
		this.idClienteAtual = idClienteAtual;
	}
}
