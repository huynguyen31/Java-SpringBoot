package com.example.SpringProject.Entity;

import com.example.SpringProject.Model.Product;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_xyz")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String productName_p;

    @Column
    @NotNull
    private String description_d;

    @Column
    @NotNull
    private String picture_p;

    @Column
    @NotNull
    private double price_p;

    @Column
    @NotNull
    private String status_s;

    public ProductEntity(){}

    public ProductEntity(String productName_p, String description_d, String picture_p, double price_p, String status_t){
        this.productName_p = productName_p;
        this.description_d = description_d;
        this.picture_p = picture_p;
        this.price_p = price_p;
        this.status_s = status_t;
    }

    public ProductEntity(Product product){
        this.productName_p = product.getProductName_p();
        this.description_d = product.getDescription_d();
        this.picture_p = product.getPicture_p();
        this.price_p = product.getPrice_p();
        this.status_s = product.getStatus_s();
    }
}
