package io.robothouse.codingassignments.assignmenttwo.DTOs;

public record TypeDTO(String code, String name) {

    public TypeDTO {
        if (code == null) throw new NullPointerException("\"code\" cannot be null");
        if (name == null) throw new NullPointerException("\"name\" cannot be null");
    }
}
