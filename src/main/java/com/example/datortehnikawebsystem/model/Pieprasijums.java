package com.example.datortehnikawebsystem.model;

import com.example.datortehnikawebsystem.paramsEnum.Params;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Pieprasijums {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tehnika_id")
    private Tehnika tehnika;

    private LocalDateTime datums;

    private String pamatojums;

    @Enumerated(EnumType.ORDINAL)
    private Params parametri;

}
