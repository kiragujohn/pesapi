/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epesa.epesapi;

/**
 *
 * @author User
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import java.io.*;
import com.mastercard.api.crossborder.*;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "ePesaPI tested working!";
    }
    
     @RequestMapping(value = "/quote")
    public String quote() throws FileNotFoundException{
         String consumerKey = "yvWUXGbJ5RkPAhhgKWPsaMryJ6yWv5-WFsneiN8tfa3e561a!92daba6f19bd4c19abc40ea66898309e0000000000000000";
       String keyAlias = "epesaKeyAlias";
       String keyPassword = "Kinyusy";     
       JSONObject json=new JSONObject();
        JSONArray results=new  JSONArray();
       InputStream is = new FileInputStream("/epesaKeyAlias-sandbox.p12"); 
       ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));  
        ApiConfig.setDebug(true);   
	ApiConfig.setSandbox(true);    
       
		try {
			RequestMap map = new RequestMap();
			map.set("partner-id", "ptnr_BEeCrYJHh2BXTXPy_PEtp-8DBOo");
			map.set("quoterequest.transaction_reference", "0700000699");
			map.set("quoterequest.sender_account_uri", "tel:+2130000");
			map.set("quoterequest.recipient_account_uri", "tel:+254070005");
			map.set("quoterequest.payment_amount.amount", "100.00");
			map.set("quoterequest.payment_amount.currency", "USD");
			map.set("quoterequest.payment_origination_country", "USA");
			map.set("quoterequest.payment_type", "P2P");                 
                        Quotes response = Quotes.create(map);  
                        json.put("proposal",response.get("quote.proposals"));                        
                        json.put("transaction_reference",response.get("quote.transaction_reference"));
                        json.put("payment_type",response.get("quote.payment_type"));  
                        return json.toString();
                }catch(Exception e){               
		System.err.println("Message: "+e.getMessage());	
                }
                return null;
                
    }

}