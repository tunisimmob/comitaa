package com.ingarch.materiaux.controllers;

import com.ingarch.materiaux.models.Presentation;
import com.ingarch.materiaux.payload.response.MessageResponse;
import com.ingarch.materiaux.repository.PresentationRepository;
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
public class PresentationController {


    @Autowired
    PresentationRepository presentationRepository;


    @PostMapping("/presentation")
    public ResponseEntity<?> createPresentation(@Valid @RequestBody Presentation presentation) {
            Presentation result = presentationRepository.save(presentation);
            return ResponseEntity.ok().body(result);
    }


    @PutMapping("/presentation")
    public ResponseEntity<Presentation> updatePresentation(@Valid @RequestBody Presentation presentation) {
        Presentation result = presentationRepository.save(presentation);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/presentation")
    public List<Presentation> getAllPresentation() {
        return presentationRepository.findAll();
    }


    @GetMapping("/lastpresentation")
    public ResponseEntity<Presentation> getLastpresentation() {
        Presentation result = presentationRepository.findTop1ByOrderByIdDesc();
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/presentation/{id}")
    public ResponseEntity<Optional<Presentation>> getPresentation(@PathVariable Long id) {
        Optional<Presentation> presentation = presentationRepository.findById(id);
        return ResponseEntity.ok().body(presentation);
    }


    @DeleteMapping("/presentation/{id}")
    public ResponseEntity<Void> deletePresentation(@PathVariable Long id) {
        presentationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
