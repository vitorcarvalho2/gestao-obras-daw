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

import br.edu.ufj.gestaoobras.dtos.ProprietarioDTO;
import br.edu.ufj.gestaoobras.models.Proprietario;
import br.edu.ufj.gestaoobras.services.ProprietarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/gto/proprietario")
public class ProprietarioController {
	
    @Autowired
	private ProprietarioService service;
    
    @GetMapping
    public ResponseEntity<Page<ProprietarioDTO>> buscartodos(Pageable pageable){
    	Page<ProprietarioDTO> result = service.findAll(pageable);
    	return ResponseEntity.ok(result);
    }

	@GetMapping("/id/{id}")
	public ResponseEntity<ProprietarioDTO> buscarum(@PathVariable Integer id) {
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<ProprietarioDTO> buscarNome(@PathVariable String nome) {
		return service.findByName(nome)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<ProprietarioDTO> buscarCpf(@PathVariable String cpf) {
		return service.findByCPF(cpf)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<@Valid ProprietarioDTO> incluir(@Valid @RequestBody Proprietario obj){
		@Valid ProprietarioDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProprietarioDTO> atualizar(@PathVariable Integer id,@RequestBody Proprietario obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	ProprietarioDTO objDTO = service.save(obj);
	
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
