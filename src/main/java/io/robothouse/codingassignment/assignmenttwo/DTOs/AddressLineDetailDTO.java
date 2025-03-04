package io.robothouse.codingassignment.assignmenttwo.DTOs;

public record AddressLineDetailDTO(String line1, String line2) {
    private final static String NOT_AVAILABLE = "Not Available";

    public String getPrettyPrinting() {
        boolean nullOrEmptyLine1 = line1 == null || line1.isEmpty();
        boolean nullOrEmptyLine2 = line2 == null || line2.isEmpty();

        if (nullOrEmptyLine1 && nullOrEmptyLine2) {
            return NOT_AVAILABLE;
        } else if (nullOrEmptyLine1) {
            return line2;
        } else if (nullOrEmptyLine2) {
            return line1;
        } else {
            return line1 + ", " + line2;
        }
    }

    public boolean checkValid() {
        return !(line1 == null || line1.isEmpty()) || !(line2 == null || line2.isEmpty());
    }
}
