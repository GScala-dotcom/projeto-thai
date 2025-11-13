package com.fiap.banksecure.app.controller;

import com.fiap.banksecure.app.domain.dto.SeguroCreateRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroCreateResponseDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutRequestDTO;
import com.fiap.banksecure.app.domain.dto.SeguroPutResponseDTO;
import com.fiap.banksecure.app.service.SeguroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoSeguro")
@RequiredArgsConstructor
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public SeguroCreateResponseDTO cadastrarSeguro(@RequestBody SeguroCreateRequestDTO seguroDto) throws Exception{
        return seguroService.doCadastrar(seguroDto);
    }

    @PutMapping("/alterar/{id}")
    public SeguroPutResponseDTO alterarSeguro(@PathVariable Long id, @RequestBody SeguroPutRequestDTO seguroDto) {
        return seguroService.doAlterar(id, seguroDto);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirSeguro(@PathVariable Long id) {
        seguroService.doExcluir(id);
    }
}
