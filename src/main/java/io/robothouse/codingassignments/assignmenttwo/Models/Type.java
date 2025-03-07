package io.robothouse.codingassignments.assignmenttwo.Models;

import java.util.Objects;

public record Type(String code, String name) {

    public Type {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }
}
