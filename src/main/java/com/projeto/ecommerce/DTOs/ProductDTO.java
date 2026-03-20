package com.projeto.ecommerce.DTOs;

import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        String description,
        double price,
        String imgURL
) {}