package com.example.javaspring.Controller;

import com.example.javaspring.Model.Product;
import com.example.javaspring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<Product> getAllProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }

    @PutMapping(path = "/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return this.productService.updateProduct(product, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        boolean ok = this.productService.deleteProduct(id);
        if (ok) {
            return "Product with id " + id + " deleted";
        } else {
            return "Error, we have a problem";
        }
    }
}
