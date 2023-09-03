package br.edu.ufj.gestaoobras.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "TotalItem")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TotalItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "codigo_totalitem")
  private int codigo;
  
  @Column(name= "descricao_totalitem",nullable = false)
  private String descricao;
  
  @Column(name = "total_totalItem")
  private Double total;

public TotalItem(String descricao, Double total) {
	super();
	this.descricao = descricao;
	this.total = total;
}
  
  
}
