package com.dev.osorio.controller.product;

import com.dev.osorio.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductController {

    @FXML
    private TableView<ProductModel> productTableView;

    @FXML
    public void initialize() {
        //Criar as Colunas da Tabela
        TableColumn<ProductModel, String> nameColumn = new TableColumn<>("Nome");
        TableColumn<ProductModel, Long> codProductColumn = new TableColumn<>("Cod Produto");
        TableColumn<ProductModel, Long> amountColumn = new TableColumn<>("Unidades");
        TableColumn<ProductModel, LocalDate> validateColumn = new TableColumn<>("Validade");

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

        //Vincular as colunas as propriedades da classe modelo
        nameColumn.setCellValueFactory(data -> data.getValue().getNameProperty());
        codProductColumn.setCellValueFactory(data -> data.getValue().getCodProductProperty().asObject());
        amountColumn.setCellValueFactory(data -> data.getValue().getAmountProperty().asObject());
        validateColumn.setCellValueFactory(data -> data.getValue().getValidateProperty());

        //Adicionar as colunas a tabela
        productTableView.getColumns().addAll(nameColumn, codProductColumn, amountColumn, validateColumn);

        //Criar uma Lista Observavel
        ObservableList<ProductModel> productObservableList = FXCollections.observableArrayList(
                new ProductModel("Chocolate", 128743L, 1850L, LocalDate.of(2027, 10, 15)),
                new ProductModel("Bolacha", 367498L, 560L, LocalDate.of(2026, 12, 5)),
                new ProductModel("Salgadinho", 761250L, 4872L, LocalDate.of(2026, 4, 18)),
                new ProductModel("Refrigerante", 490061L, 2566L, LocalDate.of(2026, 7, 20))
        );

        productTableView.setItems(productObservableList);

    }


}
