package com.example.datortehnikawebsystem.service;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.repository.PieprasijumsRepository;
import com.example.datortehnikawebsystem.repository.TehnikaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PieprasijumsService {

    private final PieprasijumsRepository pieprasijumsRepository;

    public PieprasijumsService(PieprasijumsRepository pieprasijumsRepository) {
        this.pieprasijumsRepository = pieprasijumsRepository;
    }

    public List<Pieprasijums> findAll() {
        return pieprasijumsRepository.findAll();
    }

    public Pieprasijums createPieprasijums(Pieprasijums pieprasijums) {
        return pieprasijumsRepository.save(pieprasijums);
    }
}
