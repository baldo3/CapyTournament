package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Torneo {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="ID_TORNEO", nullable=false, unique=true)
 private Long id;
 
 @Column(name="NOMBRE_TORNEO", length=50, nullable=false, unique=true)
 private String nombre;
 
 @Column(name="ESTADO", length=20, nullable=false, unique=false)
 @Enumerated(EnumType.STRING)
 private Estados estado;
 
 @Column(name="FORMATO", length=20, nullable=false, unique=false)
 @Enumerated(EnumType.STRING)
 private Formatos formato;
 
 
}
