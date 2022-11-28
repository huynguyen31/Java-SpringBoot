package com.example.SpringProject.Service;

import com.example.SpringProject.Entity.ProductEntity;
import com.example.SpringProject.Model.Product;
import com.example.SpringProject.Repository.ProductRepository;
import com.example.SpringProject.Service.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        try {
            List<Product> listProduct = new ArrayList<>();
            List<ProductEntity> listProductEntity = productRepository.findAll();
            for(ProductEntity productEntity : listProductEntity){
                Product product = new Product(productEntity);
                listProduct.add(product);
            }
            return listProduct;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findProductById(long id) {
        try {
            Optional<ProductEntity> productEntity = productRepository.findById(id);
            Product product = new Product(productEntity.get());
            return product;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProduct(ProductEntity productEntity) {
        try {
            productRepository.save(productEntity);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findProductByName(String name) {
        try {
            List<Product> listProduct = this.listAllProduct();
            List<Product> listProductByName = listProduct.stream().filter(x -> x.getProductName_p().equals(name)).collect(Collectors.toList());
            return listProductByName;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
