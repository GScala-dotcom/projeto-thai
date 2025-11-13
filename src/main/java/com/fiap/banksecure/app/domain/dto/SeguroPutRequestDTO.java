package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record TipoSeguroPutRequestDTO(String titulo, String coberturaMinima, BigDecimal valorPremioBase) {
}
