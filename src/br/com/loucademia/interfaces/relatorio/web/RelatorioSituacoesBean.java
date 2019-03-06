package br.com.loucademia.interfaces.relatorio.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

@Named
@SessionScoped
public class RelatorioSituacoesBean implements Serializable {

	@Inject
	private FacesContext facesContext;

	@EJB
	private AlunoService alunoService;

	private Situacao situacao;

	private List<Aluno> alunos;

	@Inject
	@RequestParameterMap
	private Map<String, String> requestMap;

	public void carregarRelatorio() {
		String clear = requestMap.get("clear");
		if(clear != null && Boolean.valueOf(clear)) {
			alunos = null;
			situacao = null;
			
		} else  
			gerarRelatorio();
	}
	
	public String gerarRelatorio() {
		try {
			alunos = alunoService.listSituacoesAlunos(situacao);
		} catch (ValidationException e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}

		return null;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public String maskTelefone(Integer ddd, Integer telefone) {
		if (telefone == null)
			return "";
		return "(" + ddd + ") " + telefone;
	}
}
