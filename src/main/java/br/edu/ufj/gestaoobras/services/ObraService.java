package br.edu.ufj.gestaoobras.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.gestaoobras.dtos.ObraDTO;
import br.edu.ufj.gestaoobras.models.Obra;
import br.edu.ufj.gestaoobras.repositories.ObraDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ObraService {
	
	@Autowired
	private ObraDAO dao;

	@Transactional(readOnly = true)
	public Page<ObraDTO> findAll(Pageable pageable) {
		Page<Obra> result = dao.findAll(pageable);
		return result.map(obj -> new ObraDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public Optional<ObraDTO> findById(Integer id) {
		Optional<Obra> result = dao.findById(id);
		return result.map(obj -> new ObraDTO(obj));
	}

	@Transactional
	public ObraDTO save(Obra obj) {
		return new ObraDTO(dao.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
