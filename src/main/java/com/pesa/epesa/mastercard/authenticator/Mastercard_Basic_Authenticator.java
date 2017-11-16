/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.authenticator;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.pesa.epesa.mastercard.resources.Mastercard_Properties;
import com.pesa.epesa.mastercard.resources.Property;
import com.pesa.epesa.mastercard.resources.mastercard_Client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.log4j.Logger;

/**
 *
 * @author User
 */
public class Mastercard_Basic_Authenticator {
    public static void basic_Authenticate() throws FileNotFoundException{
      final Logger logger = Logger.getLogger(mastercard_Client.class);  
      String consumerKey = Mastercard_Properties.getProperty(Property.CONSUMERKEY);
      String keyAlias =  Mastercard_Properties.getProperty(Property.KEYALIAS);            
      String keyPassword = Mastercard_Properties.getProperty(Property.KEYPASSWORD);
      //InputStream is = new FileInputStream(Mastercard_Properties.getProperty(Property.KEYSTOREPATH));  
      InputStream is = new FileInputStream(Mastercard_Properties.getProperty(Property.KEYSTOREPATH));
        logger.info("File was cound at.............."+Mastercard_Properties.getProperty(Property.KEYSTOREPATH));
      ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword)); 
      ApiConfig.setDebug(true);   
      ApiConfig.setSandbox(true);
}
    
}
