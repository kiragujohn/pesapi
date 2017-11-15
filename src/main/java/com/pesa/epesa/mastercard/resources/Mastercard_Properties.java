/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.resources;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Mastercard_Properties {
    
    static Properties properties;

    static {
        try {
            properties = new Properties();
            String propertiesFile = System.getProperty("ftproperties");
            if (propertiesFile == null) {
                properties.load(Mastercard_Properties.class.getResourceAsStream("/mastercard_configuration.properties"));
            } else {
                properties.load(new FileReader(propertiesFile));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(Property property) {
        return (String) properties.get(property.getValue());
    }
}
