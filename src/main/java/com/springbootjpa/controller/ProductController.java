package com.springbootjpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjpa.entity.Product;
import com.springbootjpa.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return new ResponseEntity(service.saveProduct(product), HttpStatus.OK);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Object> addProducts(@RequestBody List<Product> products) {
        return new ResponseEntity(service.saveProducts(products), HttpStatus.OK); 
    }

    @GetMapping("/products")
    public ResponseEntity<Object> findAllProducts() {
        return new ResponseEntity(service.getAllProducts(), HttpStatus.OK); 
    }
    
    @GetMapping("/products/{price}")
    public ResponseEntity<Object> findSelectedProducts(@PathVariable Double price) {
        return new ResponseEntity(service.getSelectedProducts(price), HttpStatus.OK);  
    }
    
    @GetMapping("/products2/{gprice}/{lprice}")
    public ResponseEntity<Object> findSelectedProducts2(@PathVariable Double gprice, @PathVariable Double lprice) {
    	System.out.println(gprice);
    	System.out.println(lprice);
        return new ResponseEntity(service.getSelectedProducts2(gprice,lprice), HttpStatus.OK) ;
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable int id) {
        return new ResponseEntity(service.getProductById(id), HttpStatus.OK)  ;
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<Object> findProductByName(@PathVariable String name) {
        return new ResponseEntity(service.getProductByName(name), HttpStatus.OK) ;
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return new ResponseEntity(service.updateProduct(product), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}