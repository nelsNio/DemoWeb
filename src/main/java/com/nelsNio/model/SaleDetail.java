package com.nelsNio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SaleDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSaleDetail;


	@ManyToOne
	@JoinColumn(name="product", nullable=false)
	private Product product;

	@ManyToOne
	@JoinColumn(name="sale", nullable=false)
	private Sale sale;

	public Long getIdSaleDetail() {
		return idSaleDetail;
	}


	public void setIdSaleDetail(Long idSaleDetail) {
		this.idSaleDetail = idSaleDetail;
	}

	public Product getProduct() {
		return product;
	}
	public SaleDetail product(Product product){
		System.out.println("entro cliet"+ product.toString());
		this.product=product;
		return  this;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
}
