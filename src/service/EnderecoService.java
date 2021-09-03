package service;

import javax.ejb.Stateless;

import model.Endereco;

@Stateless
public class EnderecoService extends GenericService<Endereco> {
	public EnderecoService() {
		super(Endereco.class);
	}
}
