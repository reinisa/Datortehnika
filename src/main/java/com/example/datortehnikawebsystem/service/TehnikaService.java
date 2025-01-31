package com.example.datortehnikawebsystem.service;

import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.repository.TehnikaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TehnikaService {

    private final TehnikaRepository tehnikaRepository;

    public TehnikaService(TehnikaRepository tehnikaRepository) {
        this.tehnikaRepository = tehnikaRepository;
    }

    public List<Tehnika> findAll() {
        return tehnikaRepository.findAll();
    }

    public Tehnika createTehnika(Tehnika tehnika) {
        return tehnikaRepository.save(tehnika);
    }
}
