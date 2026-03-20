package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    public CategoryEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public CategoryEntity create(CategoryEntity category) {
        return repository.save(category);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}