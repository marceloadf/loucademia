package br.com.loucademia.interfaces.shared.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.loucademia.application.service.DataService;
import br.com.loucademia.domain.aluno.Estado;
import br.com.loucademia.domain.aluno.Aluno.Sexo;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

@Named
@ApplicationScoped
public class DataBean implements Serializable{
	
	@EJB
	private DataService dataService;
	
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}
	
	public Situacao[] getSituacao() {
		return dataService.getSituacao();
	}
	
	public List<Estado> getEstados(){
		return dataService.listEstados();
	}
}
