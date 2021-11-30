package com.ingarch.materiaux.controllers;

import com.ingarch.materiaux.models.Devis;
import com.ingarch.materiaux.repository.DevisRepository;
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
public class DevisController {


    @Autowired
    DevisRepository devisRepository;


    @PostMapping("/devis")
    public ResponseEntity<?> createDevis(@Valid @RequestBody Devis devis) {
        Devis result = devisRepository.save(devis);
            return ResponseEntity.ok().body(result);
    }


    @PutMapping("/devis")
    public ResponseEntity<Devis> updateDevis(@Valid @RequestBody Devis devis) {
        Devis result = devisRepository.save(devis);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/devis")
    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }


    @GetMapping("/devis/{id}")
    public ResponseEntity<Optional<Devis>> getDevis(@PathVariable Long id) {
        Optional<Devis> devis = devisRepository.findById(id);
        return ResponseEntity.ok().body(devis);
    }




    @DeleteMapping("/devis/{id}")
    public ResponseEntity<Void> deleteDevis(@PathVariable Long id) {
        devisRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/countdevis")
    public Long countDevis() {
        return devisRepository.count();
    }
}
