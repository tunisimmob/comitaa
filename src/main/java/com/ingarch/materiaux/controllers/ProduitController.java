package com.ingarch.materiaux.controllers;

import com.ingarch.materiaux.models.Produit;
import com.ingarch.materiaux.repository.ProduitRepository;
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
public class ProduitController {


    @Autowired
    ProduitRepository produitRepository;


    @PostMapping("/produit")
    public ResponseEntity<Produit> createProduit(@Valid @RequestBody Produit produit) {
        Produit result = produitRepository.save(produit);
        return ResponseEntity.ok().body(result);
    }


    @PutMapping("/produit")
    public ResponseEntity<Produit> updateProduit(@Valid @RequestBody Produit produit) {
        Produit result = produitRepository.save(produit);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/produit")
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }


    @GetMapping("/produit/{id}")
    public ResponseEntity<Optional<Produit>> getProduit(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        return ResponseEntity.ok().body(produit);
    }


    @DeleteMapping("/produit/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/countproduit")
    public Long countProduit() {
        return produitRepository.count();
    }

}
