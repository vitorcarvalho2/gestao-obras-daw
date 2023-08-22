package br.edu.ufj.gestaoobras.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.gestaoobras.models.Item;

public interface ItemDAO extends JpaRepository<Item , Integer>{

	Optional<Item> findByDescricao(String descricao);
}
