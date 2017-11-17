/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.moneySend;


import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import java.io.*;
import com.mastercard.api.crossborder.*;
import com.pesa.epesa.contoller.helpers.Request_quote_helper;
import com.pesa.epesa.mastercard.authenticator.Mastercard_Basic_Authenticator;
import com.pesa.epesa.mastercard.resources.Mastercard_Properties;
import com.pesa.epesa.mastercard.resources.Property;

public class Mastercard_quote_request {
    Quotes response=new Quotes();
   public Quotes send_request(String refId){        
		try {
                    Mastercard_Basic_Authenticator.basic_Authenticate();
                    Request_quote_helper helper=new Request_quote_helper();
                    response = Quotes.create(helper.getmap(refId)); 
                    
		} catch (ApiException e) {
			System.err.println("HttpStatus: "+e.getHttpStatus());
			System.err.println("Message: "+e.getMessage());
			System.err.println("ReasonCode: "+e.getReasonCode());
			System.err.println("Source: "+e.getSource());
                
		}
                catch(FileNotFoundException ef){
                
                }
               return response;
   }
}