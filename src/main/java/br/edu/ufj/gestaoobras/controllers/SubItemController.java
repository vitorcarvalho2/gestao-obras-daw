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

import br.edu.ufj.gestaoobras.dtos.SubItemDTO;
import br.edu.ufj.gestaoobras.models.SubItem;
import br.edu.ufj.gestaoobras.services.SubItemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/gto/subitem")

public class SubItemController {
	
    @Autowired
	private SubItemService service;
    
    @GetMapping
    public ResponseEntity<Page<SubItemDTO>> buscartodos(Pageable pageable){
    	Page<SubItemDTO> result = service.findAll(pageable);
    	return ResponseEntity.ok(result);
    }

	@GetMapping("/id/{id}")
	public ResponseEntity<SubItemDTO> buscarum(@PathVariable Integer id) {
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<SubItemDTO> buscardescricao(@PathVariable String descricao) {
		return service.findByDescricao(descricao)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	//@operation("postar por id")
	@PostMapping
	public ResponseEntity<@Valid SubItemDTO> incluir(@Valid @RequestBody SubItem obj){
		@Valid SubItemDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SubItemDTO> atualizar(@PathVariable Integer id,@RequestBody SubItem obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	SubItemDTO objDTO = service.save(obj);
	
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
