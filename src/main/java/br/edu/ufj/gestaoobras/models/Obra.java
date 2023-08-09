package br.edu.ufj.gestaoobras.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name= "obra")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;
	
  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "codigo_obra")
  private int codigo;
  
  @Column(name= "descricao_obra",nullable = false)
  private String descricao;
  
  @Column(name= "localizacao_obra",nullable = false)
  private String localizacao;
  
  @Column(name= "complemento_obra")
  private String complemento;
  
  @ManyToOne
  private Proprietario proprietario;
}
