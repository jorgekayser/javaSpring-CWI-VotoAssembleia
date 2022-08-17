package com.curso.votoassembleia.service;

import com.curso.votoassembleia.model.Pauta;
import com.curso.votoassembleia.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
// acesso externo
//@SpringBootApplication
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Pauta salvar(Pauta pauta){
        return pautaRepository.save(pauta);
    }

    public List<Pauta> ListaPauta(){
        return pautaRepository.findAll();
    }

    public Optional<Pauta> buscarPautaId(Long id){
        return pautaRepository.findById(id);
    }

    public void removerPorId(Long id){
        pautaRepository.deleteById(id);
    }

}
