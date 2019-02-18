package br.com.loucademia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.domain.aluno.Aluno;

@Named
@SessionScoped
public class PesquisaAlunoBean implements Serializable{

	@EJB
	private AlunoService alunoService;
	
	private String matricula;
	private String nome;
	private Integer telefone;
	private Integer rg;
	
	private List<Aluno> alunos;
	
	public String pesquisar() {
		alunos = alunoService.listAlunos(matricula, nome, rg, telefone);
		return null;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String excluir(String matricula) {
		alunoService.delete(matricula);
		return null;
	} 
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}