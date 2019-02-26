package br.com.loucademia.application.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.Aluno.Situacao;
import br.com.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {

	@EJB
	private AlunoRepository alunoRepository;

	public void createOrUpdate(Aluno aluno) {
		if (StringUtils.isEmpty(aluno.getMatricula()))
			create(aluno);
		else
			update(aluno);
	}

	private void create(Aluno aluno) {
		Validation.assertNotEmpty(aluno);

		String maxMatricula = alunoRepository.getMaxMatriculaAno();

		aluno.gerarMatricula(maxMatricula);
		alunoRepository.store(aluno);
	}

	private void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		alunoRepository.update(aluno);
	}

	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}

	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone) {
		// return List.of(alunoRepository.findByMatricula(matricula));
		if (StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome) && rg == null && telefone == null)
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido");

		return alunoRepository.listAlunos(matricula, nome, rg, telefone);
	}

	public List<Aluno> listSituacoesAlunos(Situacao situacao) {

		if (situacao == null)
			throw new ValidationException("Selecione uma situação");

		return alunoRepository.listSituacoesAlunos(situacao);
	}

	public void delete(String matricula) {
		alunoRepository.delete(matricula);
	}

	public List<Acesso> listAcessosAlunos(String matricula, LocalDate dtInicial, LocalDate dtFinal) {
		
		if(StringUtils.isEmpty(matricula) && dtInicial == null && dtFinal == null)
			throw new ValidationException("Pelo menos um parâmetro deve ser preenchido");
			
		return alunoRepository.listAcessosAlunos(matricula, dtInicial, dtFinal);
	}
}
