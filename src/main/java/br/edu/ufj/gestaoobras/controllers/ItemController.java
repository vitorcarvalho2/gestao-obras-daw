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

import br.edu.ufj.gestaoobras.dtos.ItemDTO;
import br.edu.ufj.gestaoobras.models.Item;
import br.edu.ufj.gestaoobras.services.ItemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/gto/item")

public class ItemController {
	
    @Autowired
	private ItemService service;
    
    @GetMapping
    public ResponseEntity<Page<ItemDTO>> buscartodos(Pageable pageable){
    	Page<ItemDTO> result = service.findAll(pageable);
    	return ResponseEntity.ok(result);
    }

	@GetMapping("/id/{id}")
	public ResponseEntity<ItemDTO> buscarum(@PathVariable Integer id) {
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<ItemDTO> buscardescricao(@PathVariable String descricao) {
		return service.findByDescricao(descricao)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<@Valid ItemDTO> incluir(@Valid @RequestBody Item obj){
		@Valid ItemDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemDTO> atualizar(@PathVariable Integer id,@RequestBody Item obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	ItemDTO objDTO = service.save(obj);
	
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
