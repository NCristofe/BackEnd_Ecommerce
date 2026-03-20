package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

    public OrderEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public OrderEntity create(OrderEntity order) {
        return repository.save(order);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}