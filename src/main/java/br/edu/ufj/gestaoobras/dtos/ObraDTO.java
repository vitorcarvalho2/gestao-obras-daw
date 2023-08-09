package br.edu.ufj.gestaoobras.dtos;

import java.io.Serializable;

import br.edu.ufj.gestaoobras.models.Obra;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class ObraDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int codigo;
	
	@NotBlank
	@Size(max = 60)
	private String descricao;

	@NotBlank
	@Size(max = 60)
	private String localizacao;
		
	@NotBlank
	@Size(max = 60)
    @Email
	private String complemento;

	
	public ObraDTO(Obra obj) {
		this.codigo = obj.getCodigo();
		this.descricao = obj.getDescricao();
		this.localizacao = obj.getLocalizacao();
		this.complemento = obj.getComplemento();
	}
}
