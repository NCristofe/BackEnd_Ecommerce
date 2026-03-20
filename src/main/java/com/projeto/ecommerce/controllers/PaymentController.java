package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/{orderId}")
    public PaymentEntity create(@PathVariable UUID orderId) {
        return service.create(orderId);
    }
}
