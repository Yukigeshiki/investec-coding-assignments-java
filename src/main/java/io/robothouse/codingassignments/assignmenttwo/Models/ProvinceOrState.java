package io.robothouse.codingassignments.assignmenttwo.Models;

import java.util.Objects;

public record ProvinceOrState(String code, String name) {

    public ProvinceOrState {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }
}
