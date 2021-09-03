package service;

import javax.ejb.Stateless;

import model.Cliente;

@Stateless
public class ClienteService extends GenericService<Cliente> {
	public ClienteService() {
		super(Cliente.class);
	}
	
	public void gravarClienteComEndereco(Cliente c) {
		getEntityManager().persist(c.getEndereco());
		create(c);
	}
}
