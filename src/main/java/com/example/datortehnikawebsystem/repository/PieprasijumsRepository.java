package com.example.datortehnikawebsystem.repository;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PieprasijumsRepository extends JpaRepository<Pieprasijums, Long> {
    List<Pieprasijums> findAll();
}
