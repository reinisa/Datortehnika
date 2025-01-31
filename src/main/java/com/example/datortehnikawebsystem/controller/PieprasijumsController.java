package com.example.datortehnikawebsystem.controller;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.service.PieprasijumsService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pieprasijums")
public class PieprasijumsController {

    private final PieprasijumsService pieprasijumsService;

    public PieprasijumsController(PieprasijumsService pieprasijumsService) {
        this.pieprasijumsService = pieprasijumsService;
    }

    @GetMapping("/getAllPieprasijums")
    public ResponseEntity<List<Pieprasijums>>  findAllPieprasijums() {
        return ResponseEntity.ok(pieprasijumsService.findAll());
    }

    @PostMapping("/createPieprasijums")
    public ResponseEntity<Pieprasijums> createPieprasijums(@RequestBody Pieprasijums pieprasijums) {
        pieprasijums.setDatums(LocalDateTime.now());
        Pieprasijums saglabataisPieprasijums = pieprasijumsService.createPieprasijums(pieprasijums);
        return ResponseEntity.ok(saglabataisPieprasijums);
    }
}
