package com.searchhouse.searchhouse.utils;

import java.util.UUID;

public class Utils {
    // This class will be used for functions used generally in the application

    // to generate token during user/agent creations
    public static String generatetoken() {
        return UUID.randomUUID().toString();
    }

}
