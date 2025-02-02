package com.example.datortehnikawebsystem.service;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.paramsEnum.Status;
import com.example.datortehnikawebsystem.repository.PieprasijumsRepository;
import com.example.datortehnikawebsystem.repository.TehnikaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Slf4j
public class PieprasijumsService {

    private final PieprasijumsRepository pieprasijumsRepository;

    public PieprasijumsService(PieprasijumsRepository pieprasijumsRepository) {
        this.pieprasijumsRepository = pieprasijumsRepository;
    }

    public List<Pieprasijums> findAll() {
//        log.info("Retreiving all pieprasijums");
        return pieprasijumsRepository.findAll();
    }

    public Pieprasijums createPieprasijums(Pieprasijums pieprasijums) {
        if (pieprasijums.getId() != null) {
            throw new IllegalArgumentException("ID should not be provided when creating a new Pieprasijums.");
        }
        return pieprasijumsRepository.save(pieprasijums);
    }

    public Pieprasijums findById(Long id) {
//        log.info("Retreiving pieprasijums by id");
        return pieprasijumsRepository.findById(id).orElse(null);
    }

    public Pieprasijums updatePieprasijums(Long id, Status status) {
//        log.info("Updating pieprasijums");
        Pieprasijums pieprasijums = findById(id);
        pieprasijums.setStatus(status);
        return pieprasijumsRepository.save(pieprasijums);
    }

    public String deletePieprasijums(Long id) {
//        log.info("Deleting pieprasijums");
        Pieprasijums pieprasijums = findById(id);
        pieprasijumsRepository.delete(pieprasijums);
        return "Pieprasijums deleted";
    }
}
