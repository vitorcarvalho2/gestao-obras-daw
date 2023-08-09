package br.edu.ufj.gestaoobras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.gestaoobras.models.Obra;

public interface ObraDAO extends JpaRepository<Obra, Integer> {


}
