package com.dev.osorio.controller.product;

import com.dev.osorio.config.HttpConfig;
import com.dev.osorio.mapper.ProductMapper;
import com.dev.osorio.model.ProductModel;
import com.dev.osorio.presenter.ProductPresenter;
import com.dev.osorio.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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

    private ProductMapper productMapper;
    private ProductPresenter  productPresenter;

    @FXML
    public void initialize() {

        productMapper = ProductMapper.INSTANCE;
        productPresenter = new ProductPresenter(new ProductService(new HttpConfig(), new ObjectMapper()));

        tableConfig();
        productTableView.setVisible(false);

    }

    @FXML
    public void getProductByData() {
        productPresenter.getProductByData(
                txtFieldSearch.getText(),
                response -> {
                    ProductModel model = productMapper.toModel(response);
                    productTableView.setItems(FXCollections.observableArrayList(model));
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

    private void tableConfig() {
        //Vincular as colunas as propriedades da classe modelo
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().name()));
        codProductColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().codProduct()));
        unitColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().unit()).asObject());
        validateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().validate()));

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


}
