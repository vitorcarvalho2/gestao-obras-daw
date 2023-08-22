package br.edu.ufj.gestaoobras.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Itens")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_item")
	private int codigo;

	@Column(name = "descricao_item", nullable = false)
	private String descricao;

	@Column(name = "complemento_item", nullable = false)
	private String complemento;
	
	@OneToMany
    private List<SubItem> subItens= new ArrayList<>();

	
	public Item(int codigo, String descricao,String complemento) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.complemento = complemento;
	}
}