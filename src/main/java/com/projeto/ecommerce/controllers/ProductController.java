package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public ProductEntity update(@PathVariable UUID id,
                                @RequestBody ProductEntity product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}