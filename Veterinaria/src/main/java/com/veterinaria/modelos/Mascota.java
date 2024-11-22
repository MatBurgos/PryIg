/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.modelos;

import jakarta.persistence.*;
import java.util.List;
import com.veterinaria.modelos.Turno;

@Entity
@Table(name = "mascotas")
public abstract class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_duenio", nullable = false)
    private Duenio duenio;
    
    @Column(nullable = false, length = 30)
    private String nombre;
    
    private Integer edad;
    private Float peso;
    
    @Column(length = 1)
    private String sexo;
    
    @Column(nullable = false)
    private Integer tipo; // 1 = Perro, 2 = Gato
    
    @Column(nullable = false, length = 25)
    private String raza;
    
    @Column(nullable = false, length = 10)
    private String codigo;
    
    @OneToMany(mappedBy = "mascota")
    private List<Turno> turnos;

    public Mascota() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Duenio getDuenio() { return duenio; }
    public void setDuenio(Duenio duenio) { this.duenio = duenio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }
    public Float getPeso() { return peso; }
    public void setPeso(Float peso) { this.peso = peso; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public Integer getTipo() { return tipo; }
    public void setTipo(Integer tipo) { this.tipo = tipo; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public List<Turno> getTurnos() { return turnos; }
    public void setTurnos(List<Turno> turnos) { this.turnos = turnos; }
}