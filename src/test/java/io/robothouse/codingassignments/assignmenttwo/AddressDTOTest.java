package io.robothouse.codingassignments.assignmenttwo;

import io.robothouse.codingassignments.assignmenttwo.DTOs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests for the AddressDTO class - Q2 (a) (and by extension (b)), (c) and (d).
 */
public class AddressDTOTest {

    @Test
    public void testPrettyPrintWithAllFields() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        String expected = "Home: 123 Main St, Apt 4B - Los Angeles - California - 90001 - United States";
        assertEquals(expected, address.prettyPrint());
    }

    @Test
    public void testPrettyPrintWithMissingFields() {
        TypeDTO type = new TypeDTO("1", "Office");
        AddressDTO address = new AddressDTO("2", type, null, null, null, null, null, null, "2023-10-01");

        String expected = "Office: Not Available - Not Available - Not Available - Not Available - Not Available";
        assertEquals(expected, address.prettyPrint());
    }

    @Test
    public void testPrettyPrintWithPartialFields() {
        TypeDTO type = new TypeDTO("1", "Vacation Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("456 Beach Rd", null);
        CountryDTO country = new CountryDTO("ZA", "South Africa");
        AddressDTO address = new AddressDTO("3", type, addressLineDetail, null, "Cape Town", country, null, null, "2023-10-01");

        String expected = "Vacation Home: 456 Beach Rd - Cape Town - Not Available - Not Available - South Africa";
        assertEquals(expected, address.prettyPrint());
    }

    @Test
    public void testPrettyPrintOfTypeWithMatchingType() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        String expected = "Home: 123 Main St, Apt 4B - Los Angeles - California - 90001 - United States";
        assertEquals(expected, address.prettyPrintOfType("Home"));
    }

    @Test
    public void testPrettyPrintOfTypeWithNonMatchingType() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        assertNull(address.prettyPrintOfType("Office"));
    }

    @Test
    public void testIsValidWithAllFields() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        assertTrue(address.isValid());
    }

    @Test
    public void testIsValidWithMissingPostalCode() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, null, "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingCountry() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", null, "90001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithInvalidPostalCode() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "ABC123", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingAddressDetails() {
        TypeDTO type = new TypeDTO("1", "Home");
        ProvinceOrStateDTO provinceOrState = new ProvinceOrStateDTO("CA", "California");
        CountryDTO country = new CountryDTO("US", "United States");
        AddressDTO address = new AddressDTO("1", type, null, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingProvinceForZA() {
        TypeDTO type = new TypeDTO("1", "Home");
        AddressLineDetailDTO addressLineDetail = new AddressLineDetailDTO("123 Main St", "Apt 4B");
        CountryDTO country = new CountryDTO("ZA", "South Africa");
        AddressDTO address = new AddressDTO("1", type, addressLineDetail, null, "Cape Town", country, "8001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }
}
