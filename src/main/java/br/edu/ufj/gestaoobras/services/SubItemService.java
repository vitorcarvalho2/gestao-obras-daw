package br.edu.ufj.gestaoobras.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.gestaoobras.dtos.SubItemDTO;
import br.edu.ufj.gestaoobras.exceptionhandler.BusinessException;
import br.edu.ufj.gestaoobras.models.SubItem;
import br.edu.ufj.gestaoobras.repositories.SubItemDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubItemService {

	@Autowired
	private SubItemDAO dao;


	@Transactional(readOnly = true)
	public Page<SubItemDTO> findAll(Pageable pageable) {
		Page<SubItem> result = dao.findAll(pageable);
		return result.map(obj -> new SubItemDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<SubItemDTO> findById(Integer id) {
		Optional<SubItem> result = dao.findById(id);
		return result.map(obj -> new SubItemDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<SubItemDTO> findByDescricao(String descricao) {
		Optional<SubItem> result = dao.findByDescricao(descricao);
		return result.map(obj -> new SubItemDTO(obj));

	}

	@Transactional
	public SubItemDTO save(SubItem obj) {
		boolean descricaoExists = dao.findByDescricao(obj.getDescricao()).stream().anyMatch(objResult -> !objResult.equals(obj));

		if (descricaoExists) {
			throw new BusinessException("descrição já existente!");
		}

		return new SubItemDTO(dao.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
