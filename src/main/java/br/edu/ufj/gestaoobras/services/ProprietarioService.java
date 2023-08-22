package br.edu.ufj.gestaoobras.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.gestaoobras.dtos.ProprietarioDTO;
import br.edu.ufj.gestaoobras.exceptionhandler.BusinessException;
import br.edu.ufj.gestaoobras.models.Proprietario;
import br.edu.ufj.gestaoobras.repositories.ProprietarioDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioDAO dao;


	@Transactional(readOnly = true)
	public Page<ProprietarioDTO> findAll(Pageable pageable) {
		Page<Proprietario> result = dao.findAll(pageable);
		return result.map(obj -> new ProprietarioDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<ProprietarioDTO> findById(Integer id) {
		Optional<Proprietario> result = dao.findById(id);
		return result.map(obj -> new ProprietarioDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<ProprietarioDTO> findByName(String nome) {
		Optional<Proprietario> result = dao.findByNome(nome);
		return result.map(obj -> new ProprietarioDTO(obj));

	}

	@Transactional(readOnly = true)
	public Optional<ProprietarioDTO> findByCPF(String cpf) {
		Optional<Proprietario> result = dao.findByCpf(cpf);
		return result.map(obj -> new ProprietarioDTO(obj));

	}

	@Transactional(readOnly = true)
	public Optional<ProprietarioDTO> findByEmail(String email) {
		Optional<Proprietario> result = dao.findByEmail(email);
		return result.map(obj -> new ProprietarioDTO(obj));

	}

	@Transactional
	public ProprietarioDTO save(Proprietario obj) {
		boolean cpfExists = dao.findByCpf(obj.getCpf()).stream().anyMatch(objResult -> !objResult.equals(obj));

		if (cpfExists) {
			throw new BusinessException("CPF já existente!");
		}

		boolean emailExists = dao.findByEmail(obj.getEmail()).stream().anyMatch(objResult -> !objResult.equals(obj));

		if (emailExists) {
			throw new BusinessException("E-mail já existente!");
		}

		return new ProprietarioDTO(dao.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
