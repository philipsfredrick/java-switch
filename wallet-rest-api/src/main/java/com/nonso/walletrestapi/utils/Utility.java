package com.nonso.walletrestapi.utils;

import java.util.UUID;

public class Utility {
    public static String generateWalletID() {
        String digits = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        return digits.substring(0, 10);
    }

    public static String generateOrderCode() {
        String codePath = UUID.randomUUID().toString()
                .substring(0,6).replace("-", "");
        String timePath = String.valueOf(System.currentTimeMillis());
        return new StringBuilder().append(codePath)
                .append(timePath).toString()
                .toUpperCase();
    }
}
