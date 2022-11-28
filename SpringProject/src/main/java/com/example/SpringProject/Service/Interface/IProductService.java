package com.example.SpringProject.Service.Interface;

import com.example.SpringProject.Entity.ProductEntity;
import com.example.SpringProject.Model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listAllProduct();
    public Product findProductById(long id);
    public void saveProduct(ProductEntity productEntity);
    public void deleteProduct(long id);
    public List<Product> findProductByName(String name);
}
