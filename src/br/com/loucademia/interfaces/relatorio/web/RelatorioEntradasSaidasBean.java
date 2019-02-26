package br.com.loucademia.interfaces.relatorio.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;

@Named
@SessionScoped
public class RelatorioEntradasSaidasBean implements Serializable {

	@EJB
	private AlunoService alunoService;

	@Inject
	private FacesContext facesContext;

	private String matricula;

	private LocalDate dtInicial;

	private LocalDate dtFinal;

	private List<Acesso> acessos;

	public String gerarRelatorio() {
		try {
			acessos = alunoService.listAcessosAlunos(matricula, dtInicial, dtFinal);
		} catch (ValidationException e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}
		
		return null;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(LocalDate dtInicial) {
		this.dtInicial = dtInicial;
	}

	public LocalDate getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(LocalDate dtFinal) {
		this.dtFinal = dtFinal;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

}
