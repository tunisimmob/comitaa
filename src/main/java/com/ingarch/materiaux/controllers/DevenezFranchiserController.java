package com.ingarch.materiaux.controllers;

import com.ingarch.materiaux.models.DevenezFranchiser;
import com.ingarch.materiaux.payload.response.MessageResponse;
import com.ingarch.materiaux.repository.DevenezFranchiserRepository;
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
public class DevenezFranchiserController {


    @Autowired
    DevenezFranchiserRepository devenezFranchiserRepository;


    @PostMapping("/devenezFranchiser")
    public ResponseEntity<?> createdevenezFranchiser(@Valid @RequestBody DevenezFranchiser devenezFranchiser) {
            DevenezFranchiser result = devenezFranchiserRepository.save(devenezFranchiser);
            return ResponseEntity.ok().body(result);
        }


    @PutMapping("/devenezFranchiser")
    public ResponseEntity<DevenezFranchiser> updatedevenezFranchiser(@Valid @RequestBody DevenezFranchiser devenezFranchiser) {
        DevenezFranchiser result = devenezFranchiserRepository.save(devenezFranchiser);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/devenezFranchiser")
    public List<DevenezFranchiser> getAlldevenezFranchiser() {
        return devenezFranchiserRepository.findAll();
    }

    @GetMapping("/lastdevenezFranchiser")
    public ResponseEntity<DevenezFranchiser> getLastdevenezFranchiser() {
        DevenezFranchiser result = devenezFranchiserRepository.findTop1ByOrderByIdDesc();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/devenezFranchiser/{id}")
    public ResponseEntity<Optional<DevenezFranchiser>> getdevenezFranchiser(@PathVariable Long id) {
        Optional<DevenezFranchiser> devenezFranchiser = devenezFranchiserRepository.findById(id);
        return ResponseEntity.ok().body(devenezFranchiser);
    }


    @DeleteMapping("/devenezFranchiser/{id}")
    public ResponseEntity<Void> deletedevenezFranchiser(@PathVariable Long id) {
        devenezFranchiserRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/countdevfranch")
    public Long countDevenirfranch() {
        return devenezFranchiserRepository.count();
    }
}
