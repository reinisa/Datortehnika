package com.example.datortehnikawebsystem.controller;

import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.service.TehnikaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tehnika")
public class TehnikaController {

    private final TehnikaService tehnikaService;

    public TehnikaController(TehnikaService tehnikaService) {
        this.tehnikaService = tehnikaService;
    }

    @GetMapping("/getAllTehnika")
    public ResponseEntity<List<Tehnika>>  findAllTehnika() {
        return ResponseEntity.ok(tehnikaService.findAll());
    }

    @PostMapping("/createTehnika")
    public ResponseEntity<Tehnika> createTehnika(@RequestBody Tehnika tehnika) {
        Tehnika saglabataisTehnika = tehnikaService.createTehnika(tehnika);
        return ResponseEntity.ok(saglabataisTehnika);
    }
}
