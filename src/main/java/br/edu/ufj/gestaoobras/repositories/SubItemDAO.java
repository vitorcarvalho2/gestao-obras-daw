package br.edu.ufj.gestaoobras.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.gestaoobras.models.SubItem;

public interface SubItemDAO extends JpaRepository<SubItem , Integer>{

	Optional<SubItem> findByDescricao(String descricao);
}
