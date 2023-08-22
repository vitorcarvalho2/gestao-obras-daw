package br.edu.ufj.gestaoobras.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.gestaoobras.dtos.ItemDTO;
import br.edu.ufj.gestaoobras.exceptionhandler.BusinessException;
import br.edu.ufj.gestaoobras.models.Item;
import br.edu.ufj.gestaoobras.repositories.ItemDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemService {

	@Autowired
	private ItemDAO dao;


	@Transactional(readOnly = true)
	public Page<ItemDTO> findAll(Pageable pageable) {
		Page<Item> result = dao.findAll(pageable);
		return result.map(obj -> new ItemDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<ItemDTO> findById(Integer id) {
		Optional<Item> result = dao.findById(id);
		return result.map(obj -> new ItemDTO(obj));
	}

	@Transactional(readOnly = true)
	public Optional<ItemDTO> findByDescricao(String descricao) {
		Optional<Item> result = dao.findByDescricao(descricao);
		return result.map(obj -> new ItemDTO(obj));

	}

	@Transactional
	public ItemDTO save(Item obj) {
		boolean descricaoExists = dao.findByDescricao(obj.getDescricao()).stream().anyMatch(objResult -> !objResult.equals(obj));

		if (descricaoExists) {
			throw new BusinessException("descrição já existente!");
		}

		return new ItemDTO(dao.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
