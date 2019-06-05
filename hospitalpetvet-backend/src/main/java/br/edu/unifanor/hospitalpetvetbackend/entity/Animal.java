package br.edu.unifanor.hospitalpetvetbackend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "animal")
@Getter @Setter
@EqualsAndHashCode(of = {"codigo"})
public class Animal {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
     // @Column(name = "codigo_raca")
    // private long codigo_raca;

    @ManyToOne
    @JoinColumn(name = "codigo_tutor")
    @JsonBackReference
    private Tutor tutor;

    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "data_nasc")
    private Date dataNasc;

    @Column(name = "peso", length = 13, precision = 2)
    private float peso;

}