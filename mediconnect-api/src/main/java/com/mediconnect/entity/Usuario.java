package com.mediconnect.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String correo;

    private String password;

    private String rol;

    private Boolean estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}