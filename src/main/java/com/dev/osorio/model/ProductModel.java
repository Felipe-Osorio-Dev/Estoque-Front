package com.dev.osorio.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class ProductModel {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty codProduct =  new SimpleStringProperty();
    private final IntegerProperty unit =   new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> validate =  new SimpleObjectProperty<LocalDate>();

    //Construtor vazio para o mapStruct converter
    public ProductModel() {
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) { this.name.set(name); }

    public StringProperty getNameProperty() {
        return name;
    }

    public String getCodProduct() {
        return this.codProduct.get();
    }
    public void setCodProduct(String codProduct) {
        this.codProduct.set(codProduct);
    }

    public StringProperty getCodProductProperty() {
        return codProduct;
    }

    public Integer getUnit() {
        return this.unit.get();
    }
    public void setUnit(Integer unit) {
        this.unit.set(unit);
    }

    public IntegerProperty getUnitProperty() {
        return unit;
    }

    public LocalDate getValidate() {
        return this.validate.get();
    }

    public void setValidate(LocalDate validate) {
        this.validate.set(validate);
    }

    public ObjectProperty<LocalDate> getValidateProperty() {
        return validate;
    }
}
