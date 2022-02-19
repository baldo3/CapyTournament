package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TournamentEntity {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="ID_TORNEO", nullable=false, unique=true)
 private Long id;
 
 @Column(name="NOMBRE_TORNEO", length=50, nullable=false, unique=true)
 private String nombre;
 
 @Column(name="ESTADO", length=20, nullable=false, unique=false)
 @Enumerated(EnumType.STRING)
 private EstadosRepository estado;
 
 @Column(name="FORMATO", length=20, nullable=false, unique=false)
 @Enumerated(EnumType.STRING)
 private FormatosRepository formato;
 
 protected TournamentEntity() {};

 public TournamentEntity(Long id, String nombre, EstadosRepository estado, FormatosRepository formato) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.formato = formato;
 }
 
 
 
}
