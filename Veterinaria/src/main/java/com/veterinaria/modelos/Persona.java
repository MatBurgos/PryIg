/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.modelos;

import jakarta.persistence.*;


/**
 *
 * @author Mati
 */
@Entity
@Table(name = "personas")
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    
    @Column(name = "dni", nullable = false)
    private Integer dni;

    public Persona() {}

    public Persona(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public Integer getDni() { return dni; }
    public void setDni(Integer dni) { this.dni = dni; }
}