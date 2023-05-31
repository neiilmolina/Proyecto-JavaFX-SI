package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    private ArrayList<Modelo> modelos = new ArrayList<Modelo>();
    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    ArrayList<Modelo> añadirUsuario(){
        if (comprobarTextos()){
            alert.setContentText("Hay algún campo vacio");
        } else{
            Modelo modelo = new Modelo();
            modelo.setNombre(txtNombre.getText());
            modelo.setContrasenya(txtContraseña.getText());
            modelos.add(modelo);
            alert.setContentText("Usuario registrado");
        }
        alert.show();
        return modelos;
    }

    @FXML
    boolean comprobarTextos(){
        boolean vacio= false;
        if(txtNombre.getText().isBlank() || txtContraseña.getText().isBlank()){
            vacio = true;
        }
        return vacio;
    }
    @FXML
    void accionar(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}