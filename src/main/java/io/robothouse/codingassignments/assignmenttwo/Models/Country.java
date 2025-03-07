package io.robothouse.codingassignments.assignmenttwo.Models;

import java.util.Objects;

public record Country(String code, String name) {

    public Country {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }

    public boolean checkValidProvince(Address address) {
        if (code.equals("ZA")) {
            return address.provinceOrState() != null;
        }
        return true;
    }
}
