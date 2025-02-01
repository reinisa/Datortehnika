package com.example.datortehnikawebsystem.model;

import com.example.datortehnikawebsystem.paramsEnum.Params;
import com.example.datortehnikawebsystem.paramsEnum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
//@Getter
//@Setter
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

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tehnika getTehnika() {
        return tehnika;
    }

    public void setTehnika(Tehnika tehnika) {
        this.tehnika = tehnika;
    }

    public LocalDateTime getDatums() {
        return datums;
    }

    public void setDatums(LocalDateTime datums) {
        this.datums = datums;
    }

    public String getPamatojums() {
        return pamatojums;
    }

    public void setPamatojums(String pamatojums) {
        this.pamatojums = pamatojums;
    }

    public Params getParametri() {
        return parametri;
    }

    public void setParametri(Params parametri) {
        this.parametri = parametri;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}