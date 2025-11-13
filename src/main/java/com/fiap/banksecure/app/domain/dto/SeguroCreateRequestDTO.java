package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record SeguroCreateRequestDTO(
        String titulo,
        String coberturaMinima,
        BigDecimal valorPremioBase
) {}
