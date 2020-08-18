package com.app.assurance.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
//@Table(name = "pgarantie")
public class PGarantie implements Serializable {
public PGarantie() {
		super();
	}
public PGarantie(String idG ,String label, String description, Boolean obligatory, Double base_price) {
		super();
		this.idG = idG;
		this.label = label;
		this.description = description;
		this.obligatory = obligatory;
		this.base_price = base_price;
	}
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(name ="idG")
@JsonProperty("idG")
private String idG;
//@Column(name="Label")
@JsonProperty("label")
private String label;
//@Column(name="description")
@JsonProperty("description")
private String description;
//@Column(name="obligatory")
@JsonProperty("obligatory")
private Boolean obligatory;
//@Column(name="base_price")
@JsonProperty("base_price")
private Double base_price;
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
public Boolean getObligatory() {
	return obligatory;
}
public void setObligatory(Boolean obligatory) {
	this.obligatory = obligatory;
}
public Double getBase_price() {
	return base_price;
}
public void setBase_price(Double base_price) {
	this.base_price = base_price;
}




}
