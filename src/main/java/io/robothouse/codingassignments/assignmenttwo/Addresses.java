package io.robothouse.codingassignments.assignmenttwo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.robothouse.codingassignments.assignmenttwo.Models.Address;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Addresses {
    private final ArrayList<Address> addressList;

    public Addresses(String path) throws IOException {
        this.addressList = new ObjectMapper().readValue(new File(path), new TypeReference<>() {
        });
    }

    // b.
    public void prettyPrintAddresses() {
        for (Address addr : addressList) {
            System.out.println(addr);
        }
    }

    // e.
    public ArrayList<String> validateAddresses() {

        ArrayList<String> errStringList = new ArrayList<>(List.of());

        for (Address addr : addressList) {
            ArrayList<String> validationErrors = addr.validate();

            if (!validationErrors.isEmpty()) {
                String errString =
                        String.format("Address for ID: %s is invalid. Validation errors: %s", addr.id(), validationErrors);
                System.out.println(errString);
                errStringList.add(errString);
            }
        }

        return errStringList;
    }
}
