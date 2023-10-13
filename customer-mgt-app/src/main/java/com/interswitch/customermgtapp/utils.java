package com.interswitch.customermgtapp;

import java.util.UUID;

public class utils {

    public static String generateUniqueID() {
        String digits = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        String customerID = digits.substring(0, 4);
        return customerID;
    }

    public static String generateUniquePhoneNumber() {
        String digits = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        String phoneNumber = digits.substring(0, 10);
        return phoneNumber;
    }
}
