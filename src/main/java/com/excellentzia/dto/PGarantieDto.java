package com.excellentzia.dto;

public class PGarantieDto {
private String idG;
private String label;
private String description;
private boolean obligatory;
private double base_price;

    public String getIdG() {
        return idG;
    }

    public void setIdG(String idG) {
        this.idG = idG;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }

    public double getBase_price() {
        return base_price;
    }

    public void setBase_price(double base_price) {
        this.base_price = base_price;
    }
}
