/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.application.Platform;

public class MainController {
    
    @FXML
    private TabPane tabPane;

    @FXML
    private void salir() {
        Platform.exit();
    }

    @FXML
    private void mostrarMascotas() {
        abrirTab("Mascotas", "/fxml/MascotasView.fxml");
    }

    @FXML
    private void mostrarDuenios() {
        abrirTab("Dueños", "/fxml/DueniosView.fxml");
    }

    @FXML
    private void mostrarVeterinarios() {
        abrirTab("Veterinarios", "/fxml/VeterinariosView.fxml");
    }

    @FXML
    private void mostrarTurnos() {
        abrirTab("Turnos", "/fxml/TurnosView.fxml");
    }

    private void abrirTab(String titulo, String fxmlPath) {
        try {
            Tab tab = new Tab(titulo);
            tab.setContent(FXMLLoader.load(getClass().getResource(fxmlPath)));
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}