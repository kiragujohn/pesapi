/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.contoller.helpers;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.crossborder.Payment;

/**
 *
 * @author User
 */
public class Payment_request_helper {
     public RequestMap getmap(String refId){
    	RequestMap map = new RequestMap();
			map.set("partner-id", "ptnr_BEeCrYJHh2BXTXPy_PEtp-8DBOo");
			map.set("paymentrequest.transaction_reference", "0700967423711515222");
			map.set("paymentrequest.proposal_id", "suc_10000807120579256064528158");
			map.set("paymentrequest.receiving_bank_name", "Royal Exchange");
			map.set("paymentrequest.receiving_bank_branch_name", "Quad Cities");
			map.set("paymentrequest.source_of_income", "Sal");
			map.set("paymentrequest.sender.first_name", "John");
			map.set("paymentrequest.sender.middle_name", "L");
			map.set("paymentrequest.sender.last_name", "Doe");
			map.set("paymentrequest.sender.nationality", "USA");
			map.set("paymentrequest.sender.address.line1", "123MainStreet");
			map.set("paymentrequest.sender.address.line2", "5A");
			map.set("paymentrequest.sender.address.city", "Arlington");
			map.set("paymentrequest.sender.address.country_subdivision", "VA");
			map.set("paymentrequest.sender.address.postal_code", "22207");
			map.set("paymentrequest.sender.address.country", "USA");
			map.set("paymentrequest.sender.date_of_birth", "1985-06-24");
			map.set("paymentrequest.recipient.first_name", "Lee");
			map.set("paymentrequest.recipient.middle_name", "M");
			map.set("paymentrequest.recipient.last_name", "Cardholder");
			map.set("paymentrequest.recipient.nationality", "USA");
			map.set("paymentrequest.recipient.address.line1", "123MainStreet");
			map.set("paymentrequest.recipient.address.line2", "5A");
			map.set("paymentrequest.recipient.address.city", "Arlington");
			map.set("paymentrequest.recipient.address.country_subdivision", "VA");
			map.set("paymentrequest.recipient.address.postal_code", "22207");
			map.set("paymentrequest.recipient.address.country", "USA");
			map.set("paymentrequest.recipient.phone", "0016367224357");
			map.set("paymentrequest.recipient.email", "customer@gmail.com");
			return map;
     }
    
}
