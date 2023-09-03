package br.edu.ufj.gestaoobras.dtos;

import java.io.Serializable;

import br.edu.ufj.gestaoobras.models.Lancamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class LancamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int codigo;
	
	@NotNull
	@Valid
	private ObraDTO obra;
	
	@NotNull
	@Valid
	private ItemDTO item;
	
	@NotNull
	@Valid
	private SubItemDTO subitem;
	
	@NotBlank
	@Size(max = 60)
	private String descricao;

	@NotBlank
	@Size(max = 60)
	private String documento;
	
	@NotBlank
	private Double valor;
		
	@NotBlank
	@Size(max = 60)
    @Email
	private String observacoes;

	
	public LancamentoDTO(Lancamento obj) {
		this.codigo = obj.getCodigo();
		obra = new ObraDTO(obj.getObra());
		item = new ItemDTO(obj.getItem());
		subitem = new SubItemDTO(obj.getSubitem());
		this.descricao = obj.getDescricao();
		this.documento = obj.getDocumento();
		this.observacoes = obj.getObservacoes();
		this.valor = obj.getValor();
	}
}
