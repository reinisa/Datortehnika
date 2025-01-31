package com.example.datortehnikawebsystem.controller;

import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.service.PieprasijumsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pieprasijums")
public class PieprasijumsController {

    private final PieprasijumsService pieprasijumsService;

    public PieprasijumsController(PieprasijumsService pieprasijumsService) {
        this.pieprasijumsService = pieprasijumsService;
    }

    @GetMapping("/getAllPieprasijums")
    public List<Tehnika> findAllPieprasijums() {
        return pieprasijumsService.findAll();
    }

}
