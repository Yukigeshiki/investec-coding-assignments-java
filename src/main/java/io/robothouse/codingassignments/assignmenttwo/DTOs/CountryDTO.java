package io.robothouse.codingassignments.assignmenttwo.DTOs;

import java.util.Objects;

public record CountryDTO(String code, String name) {

    public CountryDTO {
        Objects.requireNonNull(code, "\"code\" cannot be null");
        Objects.requireNonNull(name, "\"name\" cannot be null");
    }

    public boolean checkValidProvince(AddressDTO address) {
        if (code.equals("ZA")) {
            return address.provinceOrState() != null;
        }
        return true;
    }
}
