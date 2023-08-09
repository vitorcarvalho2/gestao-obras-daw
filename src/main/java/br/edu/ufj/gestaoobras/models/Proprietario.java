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
@EqualsAndHashCode
@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_prop")
	private int codigo;

	
	@Column(name = "nome_prop", nullable = false)
	private String nome;

	
	@Column(name = "cpf_prop", nullable = false)
	private String cpf;

	@Column(name = "email_prop", nullable = false)
	private String email;
	
	@OneToMany
    private List<Obra> obras= new ArrayList<>();

	public Proprietario(int codigo, String nome, String cpf, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	
}
