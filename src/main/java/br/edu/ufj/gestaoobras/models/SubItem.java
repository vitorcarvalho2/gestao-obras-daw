package br.edu.ufj.gestaoobras.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SubItens")
public class SubItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_subitem")
	private int codigo;

	@Column(name = "descricao_subitem", nullable = false)
	private String descricao;

	@Column(name = "complemento_subitem", nullable = false)
	private String complemento;
	
	@ManyToOne
    private Item item;

	
	public SubItem(int codigo, String descricao,String complemento,Item item) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.complemento = complemento;
		this.item = item;
	}
}