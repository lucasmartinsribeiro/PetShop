package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import model.Atendimento;

@Stateless
public class AtendimentoService extends GenericService<Atendimento> {
	
	public AtendimentoService() {
		super(Atendimento.class);
	}
	
	public List<Atendimento> listarAtendimentosPorValorOrdenadoPorCliente(Double valor, String tipo){
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();	
    	final CriteriaQuery<Atendimento> criteriaQuery = criteriaBuilder.createQuery(Atendimento.class);
		final Root<Atendimento> atendimentoRoot = criteriaQuery.from(Atendimento.class); 

		final Expression<Double> expValor = atendimentoRoot.get("valor");
		final Expression<String> expNomeCliente = atendimentoRoot.
				get("animalAtendido").get("dono").get("nome");
		
		criteriaQuery.select(atendimentoRoot);
		
		if(tipo.equals("Maior")) {
			criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(expValor, valor));
		} else if(tipo.equals("Menor")) {
			criteriaQuery.where(criteriaBuilder.lessThan(expValor, valor));
		}
		
		criteriaQuery.orderBy(criteriaBuilder.asc(expNomeCliente));
		
		List<Atendimento> resultado = getEntityManager().createQuery(criteriaQuery).getResultList();
		
		return resultado;
	}
}
