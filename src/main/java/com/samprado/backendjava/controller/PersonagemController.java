package com.samprado.backendjava.controller;

import com.samprado.backendjava.entity.Personagem;
import com.samprado.backendjava.exception.ResourceNotFoundException;
import com.samprado.backendjava.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:3000")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    @PostMapping("/personagens")
    public Personagem addPersonagem(@RequestBody Personagem personagem){
        return personagemRepository.save(personagem);
    };

    @GetMapping("/personagens")
    public List<Personagem> fetchPersonagens(){
        return personagemRepository.findAll();
    }

    @GetMapping("/personagens/{id}")
    public ResponseEntity<Personagem> getPersonagemById(@PathVariable Long id)
    {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado com id: " + id));
        return ResponseEntity.ok(personagem);
    }

    @PutMapping("/personagens/{id}")
   public ResponseEntity<Personagem> updatePersonagem(@PathVariable Long id, @RequestBody Personagem personagemDetails){
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado com id: " + id));

        personagem.setNome(personagemDetails.getNome());
        personagem.setSobrenome(personagemDetails.getSobrenome());
        personagem.setOcupacao(personagemDetails.getOcupacao());

        Personagem updatedPersonagem = personagemRepository.save(personagem);

        return ResponseEntity.ok(updatedPersonagem);
    }

    @DeleteMapping("/personagens/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePersonagem(@PathVariable Long id){
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado com id: " + id));

        personagemRepository.delete(personagem);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
