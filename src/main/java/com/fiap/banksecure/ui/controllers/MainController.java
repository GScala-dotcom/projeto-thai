package com.fiap.banksecure.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private Label lblUsuario;
    @FXML private TextField txtBuscaNumero;
    @FXML private TextField txtBuscaCliente;
    @FXML private ComboBox<String> cbStatus;
    @FXML private TableView<?> tblApolices;

    @FXML private Button btnFiltrar;
    @FXML private Button btnLimparFiltros;
    @FXML private Button btnNovaApolice;
    @FXML private Button btnRegistrarSinistro;
    @FXML private Button btnDetalhes;
    @FXML private Button btnSair;

    @FXML
    public void initialize() {
        lblUsuario.setText("Usuário: Giovana"); // só pra ver funcionando :)
        // aqui depois você configura colunas, carrega dados, listeners etc.
    }
}