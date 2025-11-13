package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record SeguroPutRequestDTO(String titulo, String coberturaMinima, BigDecimal valorPremioBase) {
}
