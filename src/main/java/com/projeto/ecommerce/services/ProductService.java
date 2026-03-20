package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    public ProductEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProductEntity create(ProductEntity product) {
        return repository.save(product);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public ProductEntity update(UUID id, ProductEntity product) {
        return product;
    }
}