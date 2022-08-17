package com.curso.votoassembleia.service;

import com.curso.votoassembleia.model.Sessao;
import com.curso.votoassembleia.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public Sessao salvar(Sessao sessao){ return sessaoRepository.save(sessao);  }

    public List<Sessao> ListaSessao(){ return sessaoRepository.findAll();  }

    public Optional<Sessao> busacaSessaoId(Long id) { return sessaoRepository.findById(id);  }


}
