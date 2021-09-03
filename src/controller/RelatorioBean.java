package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Atendimento;
import service.AtendimentoService;

@SessionScoped
@ManagedBean
public class RelatorioBean {
	
	@EJB
	private AtendimentoService atendimentoService;
	
	private List<Atendimento>  listaAtendimentos = new ArrayList<Atendimento>();
	
	private double valorConsulta = 0D;

	private String tipo = "Maior";
	
	public void consultar() {
		System.out.println(valorConsulta);
	}
	
	public void filtrar() {
		listaAtendimentos = atendimentoService.
				listarAtendimentosPorValorOrdenadoPorCliente(valorConsulta, tipo);
		
		if(listaAtendimentos.isEmpty()) {
			FacesContext.getCurrentInstance().
			addMessage("msg", new FacesMessage("Nenhum resultado encontrado!"));
		}
	}

	public List<Atendimento> getListaAtendimentos() {
		return listaAtendimentos;
	}

	public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
