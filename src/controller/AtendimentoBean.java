package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Animal;
import model.Atendimento;
import service.AnimalService;
import service.AtendimentoService;

@ViewScoped
@ManagedBean
public class AtendimentoBean {
		@EJB
		private AtendimentoService atendimentoService;
		
		@EJB
		private AnimalService animalService;
		
		private Atendimento atendimento = new Atendimento();
		
		private List<Atendimento>  listaAtendimentos = new ArrayList<Atendimento>();
		
		private List<Animal> listaAnimais = new ArrayList<Animal>();
		
		private Long idAnimalAtual = 0L;
		
		@PostConstruct
		public void init() {		
			listaAnimais = animalService.listAll();
			listarAtendimentos();
		}
		
		public void listarAtendimentos() {
			listaAtendimentos = atendimentoService.listAll();
		}
		
		private void processarAtendimento() {
			atendimento = new Atendimento();
			idAnimalAtual = 0L;
			listarAtendimentos();
		}
		
		public void gravarAtendimento() {
			atendimento.getAnimalAtendido().setId(idAnimalAtual);
			//atendimento.setAnimalAtendido(animalService.obtemPorId(idAnimalAtual));
			atendimentoService.create(atendimento);
			
			processarAtendimento();
		}
		
		public void excluirAtendimento(Atendimento aten) {
			//atendimento.setAnimalAtendido(animalService.obtemPorId(idAnimalAtual));
			atendimentoService.remove(aten);
			//atendimento = new Atendimento();
			
			listarAtendimentos();
		}
		
		public void carregarAtendimento(Atendimento a) {
			atendimento = a;
		}
		
		public void cancelar() {
			atendimento = new Atendimento();
			listarAtendimentos();
		}

		public Atendimento getAtendimento() {
			return atendimento;
		}

		public void setAtendimento(Atendimento atendimento) {
			this.atendimento = atendimento;
		}

		public List<Atendimento> getListaAtendimentos() {
			return listaAtendimentos;
		}

		public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
			this.listaAtendimentos = listaAtendimentos;
		}

		public List<Animal> getListaAnimais() {
			return listaAnimais;
		}

		public void setListaAnimais(List<Animal> listaAnimais) {
			this.listaAnimais = listaAnimais;
		}

		public Long getIdAnimalAtual() {
			return idAnimalAtual;
		}

		public void setIdAnimalAtual(Long idAnimalAtual) {
			this.idAnimalAtual = idAnimalAtual;
		}
		
}