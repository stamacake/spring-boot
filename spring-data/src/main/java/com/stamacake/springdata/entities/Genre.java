package com.stamacake.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum  Genre {
    FANTASY("Фэнтези", "fantasy"),
    FANTASTIC("Фантастика", "fantastic"),
    MYSTERY("Детектив", "mystery");

    private String genre;
    private String name;

    public String toNormalText(){
        return (String) genre;
    }
}
