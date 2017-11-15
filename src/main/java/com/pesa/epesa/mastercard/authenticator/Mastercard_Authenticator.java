/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.authenticator;

import com.pesa.epesa.mastercard.resources.Mastercard_Properties;
import com.pesa.epesa.mastercard.resources.Property;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author User
 */
public class Mastercard_Authenticator {
public static String getBasicAuthHeader() {
String consumerKey = Mastercard_Properties.getProperty(Property.CONSUMERKEY);
String keyAlias = Mastercard_Properties.getProperty(Property.KEYALIAS);
String keyPassword =  Mastercard_Properties.getProperty(Property.KEYPASSWORD);
return "Basic " + base64Encode(consumerKey + ":" + keyPassword);
    }

    private static String base64Encode(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
