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
   public String send_request(String refId){        
		try {
                    Mastercard_Basic_Authenticator.basic_Authenticate();
                    Request_quote_helper helper=new Request_quote_helper();
                    Quotes response = Quotes.create(helper.getmap(refId));  
                    return response.get("quote.proposals.proposal[0]").toString();//+response.get("quote.proposals.proposal[1]").toString();
                    
			/*System.out.println("quote.transaction_reference-->"+response.get("quote.transaction_reference")); // quote.transaction_reference-->076009674029167501998438384
			System.out.println("quote.payment_type-->"+response.get("quote.payment_type")); // quote.payment_type-->P2P
			System.out.println("quote.proposals.proposal[0].id-->"+response.get("quote.proposals.proposal[0].id")); // quote.proposals.proposal[0].id-->suc_10000003106209246564688985
			System.out.println("quote.proposals.proposal[0].resource_type-->"+response.get("quote.proposals.proposal[0].resource_type")); // quote.proposals.proposal[0].resource_type-->proposal
			System.out.println("quote.proposals.proposal[0].fees_included-->"+response.get("quote.proposals.proposal[0].fees_included")); // quote.proposals.proposal[0].fees_included-->true
			System.out.println("quote.proposals.proposal[0].charged_amount.currency-->"+response.get("quote.proposals.proposal[0].charged_amount.currency")); // quote.proposals.proposal[0].charged_amount.currency-->USD
			System.out.println("quote.proposals.proposal[0].charged_amount.amount-->"+response.get("quote.proposals.proposal[0].charged_amount.amount")); // quote.proposals.proposal[0].charged_amount.amount-->105.00
			System.out.println("quote.proposals.proposal[0].credited_amount.currency-->"+response.get("quote.proposals.proposal[0].credited_amount.currency")); // quote.proposals.proposal[0].credited_amount.currency-->MAD
			System.out.println("quote.proposals.proposal[0].credited_amount.amount-->"+response.get("quote.proposals.proposal[0].credited_amount.amount")); // quote.proposals.proposal[0].credited_amount.amount-->1000.00
			System.out.println("quote.proposals.proposal[0].principal_amount.currency-->"+response.get("quote.proposals.proposal[0].principal_amount.currency")); // quote.proposals.proposal[0].principal_amount.currency-->USD
			System.out.println("quote.proposals.proposal[0].principal_amount.amount-->"+response.get("quote.proposals.proposal[0].principal_amount.amount")); // quote.proposals.proposal[0].principal_amount.amount-->100.00
			System.out.println("quote.proposals.proposal[0].expiration_date-->"+response.get("quote.proposals.proposal[0].expiration_date")); // quote.proposals.proposal[0].expiration_date-->2017-06-09T06:07:21.673-05:00
			System.out.println("quote.proposals.proposal[0].additional_data_list.resource_type-->"+response.get("quote.proposals.proposal[0].additional_data_list.resource_type")); // quote.proposals.proposal[0].additional_data_list.resource_type-->list
			System.out.println("quote.proposals.proposal[0].additional_data_list.item_count-->"+response.get("quote.proposals.proposal[0].additional_data_list.item_count")); // quote.proposals.proposal[0].additional_data_list.item_count-->2
			System.out.println("quote.proposals.proposal[0].additional_data_list.data.data_field[0].name-->"+response.get("quote.proposals.proposal[0].additional_data_list.data.data_field[0].name")); // quote.proposals.proposal[0].additional_data_list.data.data_field[0].name-->851
			System.out.println("quote.proposals.proposal[0].additional_data_list.data.data_field[0].value-->"+response.get("quote.proposals.proposal[0].additional_data_list.data.data_field[0].value")); // quote.proposals.proposal[0].additional_data_list.data.data_field[0].value-->456
			System.out.println("quote.proposals.proposal[0].additional_data_list.data.data_field[1].name-->"+response.get("quote.proposals.proposal[0].additional_data_list.data.data_field[1].name")); // quote.proposals.proposal[0].additional_data_list.data.data_field[1].name-->813
			System.out.println("quote.proposals.proposal[0].additional_data_list.data.data_field[1].value-->"+response.get("quote.proposals.proposal[0].additional_data_list.data.data_field[1].value")); // quote.proposals.proposal[0].additional_data_list.data.data_field[1].value-->123
			System.out.println("quote.proposals.proposal[0].quote_fx_rate-->"+response.get("quote.proposals.proposal[0].quote_fx_rate")); // quote.proposals.proposal[0].quote_fx_rate-->777
			System.out.println("quote.proposals.proposal[1].id-->"+response.get("quote.proposals.proposal[1].id")); // quote.proposals.proposal[1].id-->suc_20000224738665764466668994
			System.out.println("quote.proposals.proposal[1].resource_type-->"+response.get("quote.proposals.proposal[1].resource_type")); // quote.proposals.proposal[1].resource_type-->proposal
			System.out.println("quote.proposals.proposal[1].fees_included-->"+response.get("quote.proposals.proposal[1].fees_included")); // quote.proposals.proposal[1].fees_included-->false
			System.out.println("quote.proposals.proposal[1].charged_amount.currency-->"+response.get("quote.proposals.proposal[1].charged_amount.currency")); // quote.proposals.proposal[1].charged_amount.currency-->USD
			System.out.println("quote.proposals.proposal[1].charged_amount.amount-->"+response.get("quote.proposals.proposal[1].charged_amount.amount")); // quote.proposals.proposal[1].charged_amount.amount-->105.00
			System.out.println("quote.proposals.proposal[1].credited_amount.currency-->"+response.get("quote.proposals.proposal[1].credited_amount.currency")); // quote.proposals.proposal[1].credited_amount.currency-->MAD
			System.out.println("quote.proposals.proposal[1].credited_amount.amount-->"+response.get("quote.proposals.proposal[1].credited_amount.amount")); // quote.proposals.proposal[1].credited_amount.amount-->1000.00
			System.out.println("quote.proposals.proposal[1].principal_amount.currency-->"+response.get("quote.proposals.proposal[1].principal_amount.currency")); // quote.proposals.proposal[1].principal_amount.currency-->USD
			System.out.println("quote.proposals.proposal[1].principal_amount.amount-->"+response.get("quote.proposals.proposal[1].principal_amount.amount")); // quote.proposals.proposal[1].principal_amount.amount-->100.00
			System.out.println("quote.proposals.proposal[1].expiration_date-->"+response.get("quote.proposals.proposal[1].expiration_date")); // quote.proposals.proposal[1].expiration_date-->2017-06-09T06:07:21.673-05:00
			System.out.println("quote.proposals.proposal[1].additional_data_list.resource_type-->"+response.get("quote.proposals.proposal[1].additional_data_list.resource_type")); // quote.proposals.proposal[1].additional_data_list.resource_type-->list
			System.out.println("quote.proposals.proposal[1].additional_data_list.item_count-->"+response.get("quote.proposals.proposal[1].additional_data_list.item_count")); // quote.proposals.proposal[1].additional_data_list.item_count-->2
			System.out.println("quote.proposals.proposal[1].additional_data_list.data.data_field[0].name-->"+response.get("quote.proposals.proposal[1].additional_data_list.data.data_field[0].name")); // quote.proposals.proposal[1].additional_data_list.data.data_field[0].name-->851
			System.out.println("quote.proposals.proposal[1].additional_data_list.data.data_field[0].value-->"+response.get("quote.proposals.proposal[1].additional_data_list.data.data_field[0].value")); // quote.proposals.proposal[1].additional_data_list.data.data_field[0].value-->456
			System.out.println("quote.proposals.proposal[1].additional_data_list.data.data_field[1].name-->"+response.get("quote.proposals.proposal[1].additional_data_list.data.data_field[1].name")); // quote.proposals.proposal[1].additional_data_list.data.data_field[1].name-->813
			System.out.println("quote.proposals.proposal[1].additional_data_list.data.data_field[1].value-->"+response.get("quote.proposals.proposal[1].additional_data_list.data.data_field[1].value")); // quote.proposals.proposal[1].additional_data_list.data.data_field[1].value-->123
			System.out.println("quote.proposals.proposal[1].quote_fx_rate-->"+response.get("quote.proposals.proposal[1].quote_fx_rate")); // quote.proposals.proposal[1].quote_fx_rate-->777*/

		} catch (ApiException e) {
			System.err.println("HttpStatus: "+e.getHttpStatus());
			System.err.println("Message: "+e.getMessage());
			System.err.println("ReasonCode: "+e.getReasonCode());
			System.err.println("Source: "+e.getSource());
		}
                catch(FileNotFoundException ef){
                
                }
                return null;
   }
}