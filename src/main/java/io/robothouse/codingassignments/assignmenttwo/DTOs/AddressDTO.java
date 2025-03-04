package io.robothouse.codingassignments.assignmenttwo.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record AddressDTO(
        @NotNull String id,
        @NotNull TypeDTO type,
        AddressLineDetailDTO addressLineDetail,
        ProvinceOrStateDTO provinceOrState,
        String cityOrTown,
        CountryDTO country,
        String postalCode,
        String suburbOrDistrict,
        @NotNull String lastUpdated
) {
    private final static String NOT_AVAILABLE = "Not Available";

    // a.
    public String prettyPrint() {
        String prettyAddr = type.name() + ": " +
                (addressLineDetail != null ? addressLineDetail.getPrettyPrinting() : NOT_AVAILABLE) + " " +
                "- " + (cityOrTown != null ? cityOrTown : NOT_AVAILABLE) + " " +
                "- " + (provinceOrState != null ? provinceOrState.name() : NOT_AVAILABLE) + " " +
                "- " + (postalCode != null ? postalCode : NOT_AVAILABLE) + " " +
                "- " + (country != null ? country.name() : NOT_AVAILABLE);

        System.out.println(prettyAddr);
        return prettyAddr;
    }

    // c.
    public String prettyPrintOfType(String typeName) {
        if (Objects.equals(type.name(), typeName)) {
            return prettyPrint();
        }
        return null;
    }

    // d.
    public boolean isValid() {
        return validate().isEmpty();
    }

    public ArrayList<String> validate() {

        ArrayList<String> validationErrors = new ArrayList<>(List.of());

        boolean checkPostalCode = checkValidPostalCode(postalCode);
        boolean checkCountry = country != null;
        boolean checkAddress = addressLineDetail != null && addressLineDetail.checkValid();
        boolean checkProvince = checkCountry && country.checkValidProvince(this);

        if (!checkPostalCode) validationErrors.add("You must include a valid postal code");
        if (!checkCountry) validationErrors.add("You must include a country");
        if (!checkAddress)
            validationErrors.add("You must include valid address details (line 1 and/or 2 must be filled in)");
        if (!checkProvince) validationErrors.add("You must include a province if your country is ZA");

        return validationErrors;
    }

    private static boolean checkValidPostalCode(String str) {
        return !(str == null || str.isEmpty()) && str.matches("[0-9]+?");
    }
}


