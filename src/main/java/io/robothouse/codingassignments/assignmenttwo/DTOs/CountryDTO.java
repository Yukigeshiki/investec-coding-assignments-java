package io.robothouse.codingassignments.assignmenttwo.DTOs;

public record CountryDTO(String code, String name) {

    public CountryDTO {
        if (code == null) throw new NullPointerException("\"code\" cannot be null");
        if (name == null) throw new NullPointerException("\"name\" cannot be null");
    }

    public boolean checkValidProvince(AddressDTO address) {
        if (code.equals("ZA")) {
            return address.provinceOrState() != null;
        }
        return true;
    }
}
