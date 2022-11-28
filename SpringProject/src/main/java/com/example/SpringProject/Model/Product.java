package com.example.SpringProject.Model;

import com.example.SpringProject.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String productName_p;
    private String description_d;
    private String picture_p;
    private double price_p;
    private String status_s;

    public Product(){}

    public Product(ProductEntity productEntity){
        this.id = productEntity.getId();
        this.productName_p = productEntity.getProductName_p();
        this.description_d = productEntity.getDescription_d();
        this.picture_p = productEntity.getPicture_p();
        this.price_p = productEntity.getPrice_p();
        this.status_s = productEntity.getStatus_s();
    }
}
