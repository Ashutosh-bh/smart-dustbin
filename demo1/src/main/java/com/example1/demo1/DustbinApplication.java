package com.example1.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description This code serves the purpose of backend Api to
 *              1. Add a new dustbin to the database.
 *              2. Get all the data of dustbins from the database.
 *              3. Update the data of a dustbin of given Id.
 *              4. Last Api is to be called when the dustbin is filled, it returns the location of the nearest empty
 *                 dustbin within the specified area code or pin code.
 * @version 1
 * @Author Ashutosh Bhardwaj
 */

@SpringBootApplication
public class DustbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DustbinApplication.class, args);
    }

}

