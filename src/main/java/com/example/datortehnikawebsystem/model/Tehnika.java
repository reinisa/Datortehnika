package com.example.datortehnikawebsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
//@Setter
@RequiredArgsConstructor
@ToString

public class Tehnika {

    @Id
    private Long id;

    private String nosaukums;

    private String apraksts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public void setNosaukums(String nosaukums) {
        this.nosaukums = nosaukums;
    }

    public String getApraksts() {
        return apraksts;
    }

    public void setApraksts(String apraksts) {
        this.apraksts = apraksts;
    }
}