package com.rekap.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (validateLogin(enteredUsername, enteredPassword)) {
            openDashboard(enteredUsername, event);
        } else {
            // Tampilkan pesan kesalahan jika login tidak berhasil
            System.out.println("Login failed. Please check your credentials.");
        }
    }

    private boolean validateLogin(String username, String password) {
        // Lakukan validasi login, misalnya dengan mengambil data dari database
        // Gunakan DatabaseConnection.getConnection() untuk mendapatkan koneksi database
        // Contoh sederhana:
        return (username.equals("admin") && password.equals("admin123")) || (username.equals("siswa") && password.equals("siswa123"));
    }

    private void openDashboard(String username, ActionEvent event) {
        try {
            FXMLLoader fxmlLoader;
            if (username.equals("admin")) {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
            } else {
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("siswa.fxml"));
            }
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
