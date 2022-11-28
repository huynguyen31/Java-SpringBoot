package com.example.SpringProject.Controller;

import com.example.SpringProject.Entity.ProductEntity;
import com.example.SpringProject.Model.Product;
import com.example.SpringProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/home")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(){
        try {
            List<Product> listProduct = productService.listAllProduct();
            if(listProduct != null){
                return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable long id){
        try {
            Product product = productService.findProductById(id);
            if(product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable long id){
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        try {
            ProductEntity productEntity = new ProductEntity(product);
            productService.saveProduct(productEntity);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
