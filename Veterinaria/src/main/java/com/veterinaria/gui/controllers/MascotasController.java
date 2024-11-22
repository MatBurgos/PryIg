/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.veterinaria.gui.controllers;

import com.veterinaria.modelos.Mascota;
import com.veterinaria.dao.MascotaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class MascotasController {
    
    @FXML
    private TableView tablaMascotas;
    @FXML
    private TextField txtBuscar;

    private MascotaDAO mascotaDAO;

    @FXML
    public void initialize() {
        // Inicializar el DAO y cargar datos
        cargarMascotas();
    }

    private void cargarMascotas() {
        tablaMascotas.setItems(FXCollections.observableArrayList(mascotaDAO.obtenerTodos()));
    }

    @FXML
    private void nuevaMascota() {
        // Mostrar diálogo para nueva mascota
    }

    @FXML
    private void editarMascota() {
        // Mostrar diálogo para editar mascota seleccionada
    }

    @FXML
    private void eliminarMascota() {
        Mascota mascota = (Mascota) tablaMascotas.getSelectionModel().getSelectedItem();
        if (mascota != null) {
            // Confirmar y eliminar
        }
    }

    @FXML
    private void buscarMascota() {
        // Implementar búsqueda
    }
}