package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record TipoSeguroCreateRequestDTO(
        String titulo,
        String coberturaMinima,
        BigDecimal valorPremioBase
) {}
