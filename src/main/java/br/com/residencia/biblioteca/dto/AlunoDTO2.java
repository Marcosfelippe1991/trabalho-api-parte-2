package br.com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoDTO2 {

	private Integer numeroMatriculaAluno;
	private String nome;
	private String cpf;
	private List<EmprestimoDTO2> listaEmprestimoResumoDTO;

	public AlunoDTO2(Integer numeroMatriculaAluno, String nome, String cpf, List<EmprestimoDTO2> emprestimosDTO2) {
		super();
		this.numeroMatriculaAluno = numeroMatriculaAluno;
		this.nome = nome;
		this.cpf = cpf;
		this.listaEmprestimoResumoDTO = emprestimosDTO2;
	}

	public AlunoDTO2() {
	}

	public Integer getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}

	public void setNumeroMatriculaAluno(Integer numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<EmprestimoDTO2> getListaEmprestimoResumoDTO() {
		return listaEmprestimoResumoDTO;
	}

	public void setListaEmprestimoResumoDTO(List<EmprestimoDTO2> listaEmprestimoResumoDTO) {
		this.listaEmprestimoResumoDTO = listaEmprestimoResumoDTO;
	}

	
}
