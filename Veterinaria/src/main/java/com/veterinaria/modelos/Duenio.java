/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.modelos;


import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author Mati
 */
@Entity
@Table(name = "duenios")
public class Duenio extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    
    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

    public Duenio() {}

    public Duenio(Persona persona) {
        this.persona = persona;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
    public List<Mascota> getMascotas() { return mascotas; }
    public void setMascotas(List<Mascota> mascotas) { this.mascotas = mascotas; }
}
