package com.fiap.banksecure.app.service;

import com.fiap.banksecure.app.domain.dto.TipoSeguroCreateRequestDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroCreateResponseDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroPutRequestDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroPutResponseDTO;
import com.fiap.banksecure.app.domain.model.TipoSeguro;
import com.fiap.banksecure.app.repository.TipoSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSeguroService {

    @Autowired
    private TipoSeguroRepository tipoSeguroRepository;

    public TipoSeguroCreateResponseDTO doCadastrar(TipoSeguroCreateRequestDTO tipoSeguroDto) {
        TipoSeguro tipoSeguro = new TipoSeguro();
        tipoSeguro.setTitulo(tipoSeguroDto.titulo());
        tipoSeguro.setCoberturaMinima(tipoSeguroDto.coberturaMinima());
        tipoSeguro.setValorPremioBase(tipoSeguroDto.valorPremioBase());

        TipoSeguro salvo = tipoSeguroRepository.save(tipoSeguro);

        return new TipoSeguroCreateResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getCoberturaMinima(),
                salvo.getValorPremioBase()
        );
    }

    public TipoSeguroPutResponseDTO doAlterar(Long id, TipoSeguroPutRequestDTO tipoSeguroDto) {

        TipoSeguro tipoSeguro = tipoSeguroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nao foi possivel localizar tipo de seguro com id " + id));

        tipoSeguro.setTitulo(tipoSeguroDto.titulo());
        tipoSeguro.setCoberturaMinima(tipoSeguroDto.coberturaMinima());
        tipoSeguro.setValorPremioBase(tipoSeguroDto.valorPremioBase());

        TipoSeguro salvo = tipoSeguroRepository.save(tipoSeguro);

        return new TipoSeguroPutResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getCoberturaMinima(),
                salvo.getValorPremioBase()
        );
    }

    public void doExcluir(Long id) {
        TipoSeguro tipoSeguro = tipoSeguroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel localizar tipo de seguro com id " + id));

        tipoSeguroRepository.delete(tipoSeguro);
    }
}
