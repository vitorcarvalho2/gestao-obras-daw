package br.edu.ufj.gestaoobras.dtos;

import java.io.Serializable;

import br.edu.ufj.gestaoobras.models.Item;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
    @NotBlank
	@EqualsAndHashCode.Include
	private int codigo;

	@NotBlank
	private String descricao;

	@NotBlank
	private String complemento;
	
	

	public ItemDTO(Item obj) {
		this.codigo = obj.getCodigo();
		this.descricao = obj.getDescricao();
		this.complemento = obj.getComplemento();
	}
}
