package com.swaileh.supermarket.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id = null;
	
	@Column(name="barcode", nullable = false, unique = true)
	private String barcode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cost_price")
	private Double costPrice;
	
	@Column(name="selling_price")
	private Double sellingPrice;

	public Item() {
	}

	public Item(Integer id, String barcode, String name, Double costPrice, Double sellingPrice) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", barcode=" + barcode + ", name=" + name + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + "]";
	}	
	
	
	public void copy(Item newItem){
		this.name = newItem.getName();
		this.barcode = newItem.getBarcode();
		this.costPrice = newItem.getCostPrice();
		this.sellingPrice = newItem.getSellingPrice();
	}
 
}
