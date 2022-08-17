package com.curso.votoassembleia.controller;

import com.curso.votoassembleia.model.Pauta;
import com.curso.votoassembleia.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
//@Log4j2
//@Controller
@RequestMapping("/pauta")
@RequiredArgsConstructor

//@Api(value="API Pauta")
public class PautaController {

    @Autowired
    private final PautaService pautaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pauta salvar(@RequestBody Pauta pauta){
        return pautaService.salvar(pauta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pauta> listaPauta(){
        return pautaService.ListaPauta();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pauta buscarPautaId(@PathVariable("id") Long id){
        return pautaService.buscarPautaId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pauta não existe!"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePauta(@PathVariable("id") Long id){
        pautaService.buscarPautaId(id)
                .map(pauta -> {
                    pautaService.removerPorId((pauta.getId()));
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pauta não encontada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPauta(@PathVariable("id") Long id, @RequestBody Pauta pauta){
        pautaService.buscarPautaId(id)
                .map(pautaBase -> {
                    modelMapper.map(pauta, pautaBase);
                    pautaService.salvar(pauta);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pauta não encontada."));
    }


}
