package com.fiap.banksecure.app.domain.dto;

import java.math.BigDecimal;

public record TipoSeguroCreateResponseDTO(Long id, String titulo, String coberturaMinima, BigDecimal valorPremioBase) {

}
