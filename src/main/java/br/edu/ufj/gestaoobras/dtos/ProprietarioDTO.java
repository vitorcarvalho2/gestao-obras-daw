package br.edu.ufj.gestaoobras.dtos;

import java.io.Serializable;

import br.edu.ufj.gestaoobras.models.Proprietario;
import jakarta.validation.constraints.Email;
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

public class ProprietarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
    @NotBlank
	@EqualsAndHashCode.Include
	private int codigo;

	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;
	
	@NotBlank
    @Email
	private String email;

	public ProprietarioDTO(Proprietario obj) {
		this.codigo = obj.getCodigo();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.nome = obj.getNome();
	}
}
