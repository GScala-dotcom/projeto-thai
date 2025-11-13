package com.fiap.banksecure.app.service;

import com.fiap.banksecure.app.domain.dto.SeguroCreateRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroCreateResponseDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutResponseDTO;
import com.fiap.banksecure.app.domain.model.Seguro;
import com.fiap.banksecure.app.repository.SeguroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SeguroDaoService {

    @Autowired
    private SeguroDAO seguroDAO;

    // CREATE
    public SeguroCreateResponseDTO doCadastrar(SeguroCreateRequestDTO dto) throws Exception {

        // RF03 - validações
        if (dto.titulo() == null || dto.titulo().isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }

        if (dto.valorPremioBase() == null ||
                dto.valorPremioBase().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor Prêmio Base deve ser maior que zero.");
        }

        // Monta o objeto de domínio
        Seguro seguro = new Seguro();
        seguro.setTitulo(dto.titulo());
        seguro.setCoberturaMinima(dto.coberturaMinima());
        seguro.setValorPremioBase(dto.valorPremioBase());

        // Persiste via DAO (JDBC)
        Seguro salvo = seguroDAO.salvar(seguro);

        // Monta DTO de resposta
        return new SeguroCreateResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getCoberturaMinima(),
                salvo.getValorPremioBase()
        );
    }

    // UPDATE
    public SeguroPutResponseDTO doAlterar(Long id, SeguroPutRequestDTO dto) throws Exception {

        // Busca o registro existente
        Seguro seguro = seguroDAO.buscarPorId(id);
        if (seguro == null) {
            throw new RuntimeException("Não foi possível localizar seguro com id " + id);
        }

        // RF03 - (se quiser, pode repetir as mesmas validações de título/valor aqui)
        if (dto.titulo() == null || dto.titulo().isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }

        if (dto.valorPremioBase() == null ||
                dto.valorPremioBase().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor Prêmio Base deve ser maior que zero.");
        }

        // Atualiza campos
        seguro.setTitulo(dto.titulo());
        seguro.setCoberturaMinima(dto.coberturaMinima());
        seguro.setValorPremioBase(dto.valorPremioBase());

        // Atualiza no banco via DAO
        seguroDAO.atualizar(seguro);

        // Como o objeto "seguro" já está com os valores novos, podemos usar ele na resposta
        return new SeguroPutResponseDTO(
                seguro.getId(),
                seguro.getTitulo(),
                seguro.getCoberturaMinima(),
                seguro.getValorPremioBase()
        );
    }

    // DELETE
    public void doExcluir(Long id) throws Exception {

        // Verifica se existe
        Seguro seguro = seguroDAO.buscarPorId(id);
        if (seguro == null) {
            throw new RuntimeException("Não foi possível localizar seguro com id " + id);
        }

        // Exclui via DAO
        seguroDAO.excluir(id);
    }
}
