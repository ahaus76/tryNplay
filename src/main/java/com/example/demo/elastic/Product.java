package com.example.demo.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "kibana_sample_data_ecommerce", shards = 1, replicas = 0, refreshInterval = "1s", createIndex = true)
public class Product {

    @Id
    private String id;
    private String product_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


}
