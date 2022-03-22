package com.samprado.backendjava.repository;

import com.samprado.backendjava.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

}
