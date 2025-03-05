package io.robothouse.codingassignments.assignmenttwo.DTOs;

import java.util.Objects;

public record TypeDTO(String code, String name) {

    public TypeDTO {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }
}
