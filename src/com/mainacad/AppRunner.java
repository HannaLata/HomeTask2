package com.mainacad;

import com.mainacad.service.NumberService;

import java.util.logging.Logger;

public class AppRunner {

    private static final Logger LOGGER = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {

        int divided = 666;
        int divider = 6;

        try {
            LOGGER.info("\n" + NumberService.divide(divided, divider));
        } catch (Exception e) {
            LOGGER.severe("Error!!");
        }


    }
}
