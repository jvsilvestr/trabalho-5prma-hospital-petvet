package br.edu.unifanor.hospitalpetvet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tutor")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Tutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter	
    private long codigo;
    
    @Column(name = "nome", length = 70)
    private String nome;
    
    @Column(name = "cpf", length = 11)
    private String cpf;
    
    @Column(name = "telefone", length = 11)
    private String telefone;
    
    @Column(name = "email", length = 140)
    private String email;
    
    @Column(name = "estado", length = 40)
    private String estado;
    
    @Column(name = "cidade", length = 40)
    private String cidade;
    
    @Column(name = "cep", length = 9)
    private String cep;
    
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "complemento", length = 50)
    private String complemento;

}
