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
@Table(name = "Lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_lanc")
	private int codigo;

	@ManyToOne
	private Obra obra;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private SubItem subitem;
	
	@Column(name = "observacoes_lanc")
	private String observacoes;
	
	@Column(name= "valor_lanc")
	private Double valor;
	
	@Column(name = "documento_lanc")
	private String documento;
	
	@Column(name= "descricao_lanc",nullable = false)
	private String descricao;

	public Lancamento(int codigo, Obra obra, Item item, SubItem subitem, String observacoes, Double valor,
			String documento, String descricao) {
		super();
		this.codigo = codigo;
		this.obra = obra;
		this.item = item;
		this.subitem = subitem;
		this.observacoes = observacoes;
		this.valor = valor;
		this.documento = documento;
		this.descricao = descricao;
	}
 
	
	
}