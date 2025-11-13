package com.fiap.banksecure.app.controller;

import com.fiap.banksecure.app.domain.dto.TipoSeguroCreateRequestDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroCreateResponseDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroPutRequestDTO;
import com.fiap.banksecure.app.domain.dto.TipoSeguroPutResponseDTO;
import com.fiap.banksecure.app.service.TipoSeguroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoSeguro")
@RequiredArgsConstructor
public class TipoSeguroController {

    @Autowired
    private TipoSeguroService tipoSeguroService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoSeguroCreateResponseDTO cadastrarSeguro(@RequestBody TipoSeguroCreateRequestDTO seguroDto) throws Exception{
        return tipoSeguroService.doCadastrar(seguroDto);
    }

    @PutMapping("/alterar/{id}")
    public TipoSeguroPutResponseDTO alterarSeguro(@PathVariable Long id, @RequestBody TipoSeguroPutRequestDTO seguroDto) {
        return tipoSeguroService.doAlterar(id, seguroDto);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirSeguro(@PathVariable Long id) {
        tipoSeguroService.doExcluir(id);
    }
}
