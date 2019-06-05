package br.edu.unifanor.hospitalpetvetbackend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tutor")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Tutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Transient
	@JsonManagedReference
	private List<Animal> animais;
}
