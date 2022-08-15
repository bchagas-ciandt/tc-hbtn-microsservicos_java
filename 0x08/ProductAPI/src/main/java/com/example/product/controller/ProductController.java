package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value = "Products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("welcome")
    public String welcome() {
        return "BEM VINDO À PRODUCT REST API";
    }

    @PostMapping("addProduct")
    @ApiResponse(code = 10, message = "Required fields not informed")
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        productRepository.addProduct(p);
        return ResponseEntity.ok(p);
    }

    @GetMapping("allProducts")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products")
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> productsRetorno = productRepository.getAllProducts();
        return ResponseEntity.ok(productsRetorno);
    }

    @GetMapping("findProductById/{id}")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required")
    public ResponseEntity<Product> findProductById(@PathVariable Integer id) {
        Product product = productRepository.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("updateProduct")
    @ApiResponse(code = 14, message = "No infromation has been updated. the new information is the same as recorded in the database")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("removeProduct")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category")
    public ResponseEntity<Void> removeProduct(Product product) {
        productRepository.removeProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
