package com.curso.votoassembleia.repository;

import com.curso.votoassembleia.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository  extends JpaRepository<Pauta, Long>{

  //  List<Pauta> findAllById(Long id);

}
