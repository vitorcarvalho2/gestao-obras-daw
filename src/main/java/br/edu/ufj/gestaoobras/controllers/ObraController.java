package br.edu.ufj.gestaoobras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufj.gestaoobras.dtos.ObraDTO;
import br.edu.ufj.gestaoobras.models.Obra;
import br.edu.ufj.gestaoobras.services.ObraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/gto/obra")
public class ObraController {

	@Autowired
	private ObraService service;
	
	@GetMapping
    public ResponseEntity<Page<ObraDTO>> buscartodos(Pageable pageable){
    	Page<ObraDTO> result = service.findAll(pageable);
    	return ResponseEntity.ok(result);
    }
    
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ObraDTO> buscarum(@PathVariable Integer id) {
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<@Valid ObraDTO> incluir(@Valid @RequestBody Obra obj){
		@Valid ObraDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ObraDTO> atualizar(@PathVariable Integer id,@RequestBody Obra obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	ObraDTO objDTO = service.save(obj);
	
	return ResponseEntity.ok(objDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
