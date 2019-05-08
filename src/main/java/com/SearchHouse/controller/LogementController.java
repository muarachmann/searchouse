package com.SearchHouse.controller;

import com.SearchHouse.repository.ShRepository;
import com.SearchHouse.model.Logement;
import com.SearchHouse.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/SearchHouse")
public class LogementController {

    @Autowired
    ShRepository shRepository;

    @GetMapping("/logement")
    public List<Logement> getAllLogement() {
        return shRepository.findAll();
    }

    @PostMapping("/logement")
    public Logement createNote(@Valid @RequestBody Logement logement) {
        return shRepository.save(logement);
    }

   /* @GetMapping("/logement/{id}")
    public Logement getNoteById(@PathVariable(value = "id") Long idLog) {
        return shRepository.findById(idLog)
                .orElseThrow(() -> new ResourceNotFoundException("Logement", "id", idLog));
    }*/
}
