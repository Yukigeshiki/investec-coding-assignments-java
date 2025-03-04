package io.robothouse.codingassignments.assignmenttwo.DTOs;

public record ProvinceOrStateDTO(String code, String name) {

    public ProvinceOrStateDTO {
        if (code == null) throw new NullPointerException("\"code\" cannot be null");
        if (name == null) throw new NullPointerException("\"name\" cannot be null");
    }
}
