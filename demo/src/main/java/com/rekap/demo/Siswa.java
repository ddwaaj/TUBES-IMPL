package com.rekap.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Siswa {

    @FXML
    private TableColumn<?, ?> bindonesia;

    @FXML
    private TableColumn<?, ?> binggris;

    @FXML
    private Text identitas;

    @FXML
    private TableColumn<?, ?> ipa;

    @FXML
    private TableColumn<?, ?> mean;

    @FXML
    private TableColumn<?, ?> mtk;

    @FXML
    void initialize() {
        // Panggil metode untuk mengisi data siswa ke dalam TableView
        loadDataSiswa();
    }

    private void loadDataSiswa() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM siswa";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Anda perlu menyesuaikan dengan struktur tabel dan kolom pada database Anda
            // Misalnya, jika tabel memiliki kolom NIS, Nama, dan Nilai, Anda bisa menggunakan:
            // bindonesia.setCellValueFactory(new PropertyValueFactory<>("NIS"));
            // binggris.setCellValueFactory(new PropertyValueFactory<>("Nama"));
            // ...

            // Set data ke dalam TableView
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
