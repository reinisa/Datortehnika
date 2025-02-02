package com.example.datortehnikawebsystem.controller;


import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.paramsEnum.Status;
import com.example.datortehnikawebsystem.service.PieprasijumsService;
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
        Pieprasijums saglabataisPieprasijums = pieprasijumsService.createPieprasijums(pieprasijums);
        saglabataisPieprasijums.setDatums(LocalDateTime.now());
        return ResponseEntity.ok(saglabataisPieprasijums);
    }

    @PutMapping("/updatePieprasijums/{pieprasijumsId}/{status}")
    public ResponseEntity<Pieprasijums> updatePieprasijums(@PathVariable Long pieprasijumsId, @PathVariable Boolean status) {
        if (status) {
            return ResponseEntity.ok(pieprasijumsService.updatePieprasijums(pieprasijumsId, Status.APSTIPRINATS));
        } else {
            return ResponseEntity.ok(pieprasijumsService.updatePieprasijums(pieprasijumsId, Status.NORAIDITS));
        }
    }

    @DeleteMapping("/deletePieprasijums/{pieprasijumsId}")
    public ResponseEntity<String> deletePieprasijums(@PathVariable Long pieprasijumsId) {
        return ResponseEntity.ok(pieprasijumsService.deletePieprasijums(pieprasijumsId));
    }
}
