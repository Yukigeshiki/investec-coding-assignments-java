package io.robothouse.codingassignments.assignmenttwo.DTOs;

import java.util.Objects;

public record ProvinceOrStateDTO(String code, String name) {

    public ProvinceOrStateDTO {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }
}
