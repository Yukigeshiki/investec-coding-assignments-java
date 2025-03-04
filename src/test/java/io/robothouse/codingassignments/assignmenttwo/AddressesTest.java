package io.robothouse.codingassignments.assignmenttwo;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for the Addresses class - Q2 (e).
 */
public class AddressesTest {

    @Test
    public void testValidateAddresses() throws IOException {
        Addresses addresses = new Addresses("src/test/resources/addresses.json");

        ArrayList<String> errList = new ArrayList<>(List.of(
                "Address for ID: 2 is invalid. Validation errors: [You must include valid address details (line 1 and/or 2 must be filled in)]",
                "Address for ID: 3 is invalid. Validation errors: [You must include a province if your country is ZA]"
        ));

        ArrayList<String> result = addresses.validateAddresses();
        assertEquals(errList, result);
    }
}

