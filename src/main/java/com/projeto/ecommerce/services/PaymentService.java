package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public PaymentEntity create(UUID orderId) {

        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PaymentEntity payment = new PaymentEntity();
        payment.setMoment(LocalDate.now());
        payment.setOrder(order);

        return paymentRepository.save(payment);
    }
}