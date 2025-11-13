package com.fiap.banksecure.app.service;

import com.fiap.banksecure.app.domain.dto.SeguroCreateRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroCreateResponseDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutResponseDTO;
import com.fiap.banksecure.app.domain.model.Seguro;
import com.fiap.banksecure.app.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    public SeguroCreateResponseDTO doCadastrar(SeguroCreateRequestDTO tipoSeguroDto) throws Exception {

        if(tipoSeguroDto.titulo() == null || tipoSeguroDto.titulo().isBlank()) {
            throw new IllegalArgumentException("Titulo nao pode ser vazio!");
        } else if (tipoSeguroDto.valorPremioBase() == null || tipoSeguroDto.valorPremioBase().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor Premio Base nao pode ser vazio ou menor que 1!");
        }

        Seguro seguro = new Seguro();
        seguro.setTitulo(tipoSeguroDto.titulo());
        seguro.setCoberturaMinima(tipoSeguroDto.coberturaMinima());
        seguro.setValorPremioBase(tipoSeguroDto.valorPremioBase());

        Seguro salvo = seguroRepository.save(seguro);

        return new SeguroCreateResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getCoberturaMinima(),
                salvo.getValorPremioBase()
        );
    }

    public SeguroPutResponseDTO doAlterar(Long id, SeguroPutRequestDTO tipoSeguroDto) {

        Seguro seguro = seguroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nao foi possivel localizar tipo de seguro com id " + id));

        seguro.setTitulo(tipoSeguroDto.titulo());
        seguro.setCoberturaMinima(tipoSeguroDto.coberturaMinima());
        seguro.setValorPremioBase(tipoSeguroDto.valorPremioBase());

        Seguro salvo = seguroRepository.save(seguro);

        return new SeguroPutResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getCoberturaMinima(),
                salvo.getValorPremioBase()
        );
    }

    public void doExcluir(Long id) {
        Seguro seguro = seguroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel localizar tipo de seguro com id " + id));

        seguroRepository.delete(seguro);
    }
}
