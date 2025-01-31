package com.example.datortehnikawebsystem.repository;

import com.example.datortehnikawebsystem.model.Tehnika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TehnikaRepository extends JpaRepository<Tehnika, Long> {
    List<Tehnika> findAll();
}
