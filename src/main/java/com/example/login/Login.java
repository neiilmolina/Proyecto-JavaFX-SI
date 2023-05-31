package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ArrayList<Modelo> modelos = new ArrayList<Modelo>();

    ArrayList<Modelo> añadirModelo(ArrayList<Modelo> modelosRegistros){
        return modelosRegistros;
    }
    @FXML
    void verUsuario()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController registro = loader.getController();
        modelos = añadirModelo(registro.añadirUsuario());
        int longi = modelos.size();
        int cont = 0;
        boolean encontrado = false;

            while(cont < longi && !encontrado){
                if(modelos.get(cont).getContrasenya().equals(txtContraseña) &&
                        modelos.get(cont).getNombre().equals(txtNombre)){
                    encontrado = true;
                }
                cont++;
            }
            if(encontrado){
                alert.setContentText("Has iniciado sesión");
            } else{
                alert.setContentText("No se ha encontrado el usuario");
            }
            alert.show();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
