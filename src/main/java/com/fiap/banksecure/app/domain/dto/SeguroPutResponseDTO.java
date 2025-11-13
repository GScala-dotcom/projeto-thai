package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record SeguroPutResponseDTO(Long id, String titulo, String coberturaMinima, BigDecimal valorPremioBase) {
}
