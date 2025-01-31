package com.example.datortehnikawebsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString

public class Tehnika {

    @Id
    private Long id;

    private String nosaukums;

    private String apraksts;

}
