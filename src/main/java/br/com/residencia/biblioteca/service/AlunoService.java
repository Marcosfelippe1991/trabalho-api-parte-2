package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.dto.AlunoDTO;
import br.com.residencia.biblioteca.dto.AlunoDTO2;
import br.com.residencia.biblioteca.dto.EmprestimoDTO;
import br.com.residencia.biblioteca.dto.EmprestimoDTO2;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.AlunoRepository;
import br.com.residencia.biblioteca.repository.EmprestimoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	EmprestimoRepository emprestimoRepository;
	@Autowired
	EmprestimoService emprestimoService;

	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
		
	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno updateAluno(Aluno aluno, Integer id) {
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		alunoExistenteNoBanco.setBairro(aluno.getBairro()); //Centro
		alunoExistenteNoBanco.setCidade(aluno.getCidade()); //Petropolis
		alunoExistenteNoBanco.setComplemento(aluno.getComplemento()); //SN
		alunoExistenteNoBanco.setCpf(aluno.getCpf()); //123456789
		alunoExistenteNoBanco.setDataNascimento(aluno.getDataNascimento()); //...
		alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
		alunoExistenteNoBanco.setNome(aluno.getNome());
		alunoExistenteNoBanco.setNumeroLogradouro(aluno.getNumeroLogradouro());
		return alunoRepository.save(alunoExistenteNoBanco);
	}

	public Aluno deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
		return getAlunoById(id);
	}
	
	public Aluno toEntidade (AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCidade(alunoDTO.getCidade());
		aluno.setComplemento(alunoDTO.getComplemento());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		aluno.setLogradouro(alunoDTO.getLogradouro());
		aluno.setNome(alunoDTO.getNome());
		aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());
		return aluno;
	}
	
	public AlunoDTO toDTO(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setBairro(aluno.getBairro());
		alunoDTO.setCidade(aluno.getCidade());
		alunoDTO.setComplemento(aluno.getComplemento());
		alunoDTO.setCpf(aluno.getCpf());
		alunoDTO.setDataNascimento(aluno.getDataNascimento());
		alunoDTO.setLogradouro(aluno.getLogradouro());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setNumeroLogradouro(aluno.getNumeroLogradouro());
		alunoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
		return alunoDTO;
	}
	
	public AlunoDTO2 getAlunoByIdDTO(Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		AlunoDTO alunoDTO = toDTO(aluno);
		AlunoDTO2 alunoDTO2 = new AlunoDTO2();
		List<EmprestimoDTO2> listaEmprestimoDTO2 = new ArrayList<>();
		List<Emprestimo> listaEmprestimos2 = emprestimoRepository.findByAluno(aluno);
		for(Emprestimo emprestimo: listaEmprestimos2) {
			EmprestimoDTO2 emprestimoDTO2 = new EmprestimoDTO2();
			EmprestimoDTO emprestimoDTO = emprestimoService.toDTO(emprestimo);
			emprestimoDTO2.setCodigoEmprestimo(emprestimoDTO.getCodigoEmprestimo());
			emprestimoDTO2.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
			emprestimoDTO2.setDataEntrega(emprestimoDTO.getDataEntrega());
			listaEmprestimoDTO2.add(emprestimoDTO2);
		}
		alunoDTO2.setNumeroMatriculaAluno(alunoDTO.getNumeroMatriculaAluno());
		alunoDTO2.setNome(alunoDTO.getNome());
		alunoDTO2.setCpf(alunoDTO.getCpf());
		alunoDTO2.setListaEmprestimoResumoDTO(listaEmprestimoDTO2);
		return alunoDTO2;
	}
	
}