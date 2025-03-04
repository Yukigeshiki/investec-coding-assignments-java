package io.robothouse.codingassignments.assignmenttwo.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record CountryDTO(@NotNull String code, @NotNull String name) {

    public boolean checkValidProvince(AddressDTO address) {
        if (Objects.equals(code, "ZA")) {
            return address.provinceOrState() != null;
        }
        return true;
    }
}
