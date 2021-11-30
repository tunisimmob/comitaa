package com.ingarch.materiaux.controllers;

import com.ingarch.materiaux.models.Actualite;
import com.ingarch.materiaux.payload.response.MessageResponse;
import com.ingarch.materiaux.repository.ActualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Transactional
public class ActualiteController {


    @Autowired
    ActualiteRepository actualiteRepository;


    @PostMapping("/actualite")
    public ResponseEntity<?> createActualite(@Valid @RequestBody Actualite actualite) {
        Actualite result = actualiteRepository.save(actualite);
            return ResponseEntity.ok().body(result);
        }



    @PutMapping("/actualite")
    public ResponseEntity<Actualite> updateActualite(@Valid @RequestBody Actualite actualite) {
        Actualite result = actualiteRepository.save(actualite);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/actualite")
    public List<Actualite> getAllActualite() {
        return actualiteRepository.findAll();
    }


    @GetMapping("/actualite/{id}")
    public ResponseEntity<Optional<Actualite>> getActualite(@PathVariable Long id) {
        Optional<Actualite> actualite = actualiteRepository.findById(id);
        return ResponseEntity.ok().body(actualite);
    }


    @DeleteMapping("/actualite/{id}")
    public ResponseEntity<Void> deleteActualite(@PathVariable Long id) {
        actualiteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/countactualite")
    public Long countActualite() {
        return actualiteRepository.count();
    }
}
