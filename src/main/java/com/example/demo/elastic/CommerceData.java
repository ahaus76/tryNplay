package com.example.demo.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@Document(indexName = "kibana_sample_data_ecommerce", shards = 1, replicas = 0, refreshInterval = "1s", createIndex = true)
public class CommerceData {

	@Id
	private String id;
	private String category;
	private String customer_first_name;
	private List<Product> products;

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	/**
	 * @param customer_first_name
	 */
	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
