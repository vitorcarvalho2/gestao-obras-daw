package br.edu.ufj.gestaoobras.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufj.gestaoobras.dtos.TotalItemDTO;
import br.edu.ufj.gestaoobras.models.Lancamento;

public interface LancamentoDAO extends JpaRepository<Lancamento , Integer>{

	@Query("SELECT new net.ufjnet.gestaoobra.TotalItemDTO(obj.item,SUM(obj.valor)) FROM Lancamento AS ob GROUP BY obj.item")
	List<TotalItemDTO> totalItem();
}
