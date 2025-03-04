package io.robothouse.codingassignments.assignmenttwo.DTOs;

import java.util.ArrayList;
import java.util.List;

public record AddressDTO(
        String id,
        TypeDTO type,
        AddressLineDetailDTO addressLineDetail,
        ProvinceOrStateDTO provinceOrState,
        String cityOrTown,
        CountryDTO country,
        String postalCode,
        String suburbOrDistrict,
        String lastUpdated
) {
    private final static String NOT_AVAILABLE = "Not Available";

    public AddressDTO {
        if (id == null) throw new NullPointerException("\"id\" cannot be null");
        if (type == null) throw new NullPointerException("\"type\" cannot be null");
        if (lastUpdated == null) throw new NullPointerException("\"lastUpdated\" cannot be null");
    }

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
        if (type.name().equals(typeName)) {
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

        boolean validPostalCode = checkValidPostalCode(postalCode);
        boolean validCountry = country != null;
        boolean validAddress = addressLineDetail != null && addressLineDetail.checkValid();
        boolean validProvince = validCountry && country.checkValidProvince(this);

        if (!validPostalCode) validationErrors.add("You must include a valid postal code");
        if (!validCountry) validationErrors.add("You must include a country");
        if (!validAddress)
            validationErrors.add("You must include valid address details (line 1 and/or 2 must be filled in)");
        if (!validProvince) validationErrors.add("You must include a province if your country is ZA");

        return validationErrors;
    }

    private static boolean checkValidPostalCode(String str) {
        return !(str == null || str.isEmpty()) && str.matches("[0-9]+?");
    }
}


