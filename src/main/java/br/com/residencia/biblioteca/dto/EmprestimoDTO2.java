package br.com.residencia.biblioteca.dto;

import java.time.Instant;

public class EmprestimoDTO2 {

	private Integer codigoEmprestimo;
	private Instant dataEmprestimo;
	private Instant dataEntrega;

	
	public EmprestimoDTO2(Integer codigoEmprestimo, Instant dataEmprestimo, Instant dataEntrega) {
		super();
		this.codigoEmprestimo = codigoEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
	}

	public EmprestimoDTO2() {

	}

	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}

	public Instant getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Instant dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Instant getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

}
