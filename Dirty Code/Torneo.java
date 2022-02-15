package com.example.demo;
@Entity
@Table(name="TORNEO", schema="capyTounament")
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
