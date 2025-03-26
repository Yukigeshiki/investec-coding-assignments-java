package io.robothouse.codingassignments.assignmenttwo.Models;

import java.util.ArrayList;
import java.util.Objects;

public record Address(
        String id,
        Type type,
        AddressLineDetail addressLineDetail,
        ProvinceOrState provinceOrState,
        String cityOrTown,
        Country country,
        String postalCode,
        String suburbOrDistrict,
        String lastUpdated
) {
    private final static String NOT_AVAILABLE = "Not Available";

    public Address {
        Objects.requireNonNull(id, "\"id\" cannot be null");
        Objects.requireNonNull(type, "\"type\" cannot be null");
        Objects.requireNonNull(lastUpdated, "\"lastUpdated\" cannot be null");
    }

    // a.
    @Override
    public String toString() {
        return type.name() + ": " +
                (addressLineDetail != null ? addressLineDetail.getPrettyPrinting() : NOT_AVAILABLE) + " " +
                "- " + (cityOrTown != null ? cityOrTown : NOT_AVAILABLE) + " " +
                "- " + (provinceOrState != null ? provinceOrState.name() : NOT_AVAILABLE) + " " +
                "- " + (postalCode != null ? postalCode : NOT_AVAILABLE) + " " +
                "- " + (country != null ? country.name() : NOT_AVAILABLE);
    }

    // c.
    public void prettyPrintOfType(String typeName) {
        if (type.name().equals(typeName)) {
            System.out.println(this);
        }
    }

    // d.
    public boolean isValid() {
        return validate().isEmpty();
    }

    public ArrayList<String> validate() {
        ArrayList<String> validationErrors = new ArrayList<>();

        boolean validPostalCode = checkValidPostalCode(postalCode);
        boolean validCountry = country != null;
        boolean validAddress = addressLineDetail != null && addressLineDetail.checkValid();
        boolean validProvince = validCountry && country.checkValidProvince(this);

        // independent checks
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


