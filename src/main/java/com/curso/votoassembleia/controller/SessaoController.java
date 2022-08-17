package com.curso.votoassembleia.controller;

import com.curso.votoassembleia.model.Sessao;
import com.curso.votoassembleia.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController

@RequestMapping("/sessao")
@RequiredArgsConstructor

public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sessao salvar(@RequestBody Sessao sessao){
        return sessaoService.salvar(sessao);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sessao> ListaSessao(){
        return sessaoService.ListaSessao();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sessao buscarSessaoId(@PathVariable("id") Long id){
        return sessaoService.busacaSessaoId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sessão não encontrada."));

    }

}
