package io.robothouse.codingassignments.assignmenttwo;

import io.robothouse.codingassignments.assignmenttwo.Models.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests for the AddressDTO class - Q2 (a) (and by extension (b)), (c) and (d).
 */
public class AddressTest {

    @Test
    public void testToStringWithAllFields() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        String expected = "Home: 123 Main St, Apt 4B - Los Angeles - California - 90001 - United States";
        assertEquals(expected, address.toString());
    }

    @Test
    public void testToStringWithMissingFields() {
        Type type = new Type("1", "Office");
        Address address = new Address("2", type, null, null, null, null, null, null, "2023-10-01");

        String expected = "Office: Not Available - Not Available - Not Available - Not Available - Not Available";
        assertEquals(expected, address.toString());
    }

    @Test
    public void testToStringWithPartialFields() {
        Type type = new Type("1", "Vacation Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("456 Beach Rd", null);
        Country country = new Country("ZA", "South Africa");
        Address address = new Address("3", type, addressLineDetail, null, "Cape Town", country, null, null, "2023-10-01");

        String expected = "Vacation Home: 456 Beach Rd - Cape Town - Not Available - Not Available - South Africa";
        assertEquals(expected, address.toString());
    }

    @Test
    public void prettyPrintOfTypeExecutesPrettyPrintWhenTypeMatches() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        address.prettyPrintOfType("Home");

        System.setOut(originalOut);
        String expectedOutput = address + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void prettyPrintOfTypeDoesNotExecutePrettyPrintWhenTypeDoesNotMatch() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        address.prettyPrintOfType("Office");

        System.setOut(originalOut);
        assertEquals("", outContent.toString());
    }


    @Test
    public void testIsValidWithAllFields() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        assertTrue(address.isValid());
    }

    @Test
    public void testIsValidWithMissingPostalCode() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, null, "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingCountry() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", null, "90001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithInvalidPostalCode() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, addressLineDetail, provinceOrState, "Los Angeles", country, "ABC123", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingAddressDetails() {
        Type type = new Type("1", "Home");
        ProvinceOrState provinceOrState = new ProvinceOrState("CA", "California");
        Country country = new Country("US", "United States");
        Address address = new Address("1", type, null, provinceOrState, "Los Angeles", country, "90001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }

    @Test
    public void testIsValidWithMissingProvinceForZA() {
        Type type = new Type("1", "Home");
        AddressLineDetail addressLineDetail = new AddressLineDetail("123 Main St", "Apt 4B");
        Country country = new Country("ZA", "South Africa");
        Address address = new Address("1", type, addressLineDetail, null, "Cape Town", country, "8001", "Downtown", "2023-10-01");

        assertFalse(address.isValid());
    }
}
