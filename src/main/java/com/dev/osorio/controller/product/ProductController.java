package com.dev.osorio.controller.product;

import com.dev.osorio.model.ProductModel;
import com.dev.osorio.presenter.ProductPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductController {

    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtFieldSearch;
    @FXML
    private TableView<ProductModel> productTableView;
    @FXML
    private TableColumn<ProductModel, String> nameColumn;
    @FXML
    private TableColumn<ProductModel, String> codProductColumn;
    @FXML
    private TableColumn<ProductModel, Integer> unitColumn;
    @FXML
    private TableColumn<ProductModel, LocalDate> validateColumn;
    private ProductPresenter  productPresenter;
    private ObservableList<ProductModel> tableListItem;

    public void setPresenter(ProductPresenter productPresenter) {
        this.productPresenter = productPresenter;
    }

    @FXML
    public void initialize() {
        tableConfig();
        productTableView.setVisible(false);
    }

    @FXML
    public void getProductByData() {
        String text = txtFieldSearch.getText();

        if (isValid(text)) {
            productPresenter.getProductByData(
                    text,
                    model -> {
                        tableListItem = FXCollections.observableArrayList(model);
                        productTableView.setItems(tableListItem);
                        productTableView.setVisible(true);
                    },
                    error -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Produto não encontrado");
                        alert.setContentText(error.getMessage());
                        alert.showAndWait();
                    }
            );
        }

    }

    private void tableConfig() {
        //Vincular as colunas as propriedades da classe modelo
        nameColumn.setCellValueFactory(data -> data.getValue().getNameProperty());
        codProductColumn.setCellValueFactory(data -> data.getValue().getCodProductProperty());
        unitColumn.setCellValueFactory(data -> data.getValue().getUnitProperty().asObject());
        validateColumn.setCellValueFactory(data -> data.getValue().getValidateProperty());

        //Formatar a data da coluna validateColumn para o padrao Brasileiro
        dateFormatter();
    }

    private void dateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        validateColumn.setCellFactory(column -> {
            return new TableCell<ProductModel, LocalDate>() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        return;
                    }
                    setText(formatter.format(item));
                }
            };
        });
    }

    private Boolean isValid(String text) {
        if (text == null || text.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campo de Texto vazio");
            alert.setContentText("O campo de texto deve ser preenchido");
            alert.showAndWait();

            return false;
        }

        return true;
    }
}
