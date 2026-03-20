package com.projeto.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_payment")
public class PaymentEntity {

    @Id
    private UUID id;

    private LocalDate moment;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private OrderEntity order;
}