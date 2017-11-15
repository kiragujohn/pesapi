/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.contoller.helpers;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.crossborder.Quotes;
import java.util.Map;

/**
 *
 * @author User
 */
public class Request_quote_helper {    
    public RequestMap getmap(String refId){
    RequestMap map = new RequestMap();
map.set("partner-id", "ptnr_BEeCrYJHh2BXTXPy_PEtp-8DBOo");
//map.set("quoterequest.transaction_reference", "0762768");
map.set("quoterequest.transaction_reference",refId);
map.set("quoterequest.sender_account_uri", "tel:+2130000");
map.set("quoterequest.recipient_account_uri", "tel:+254070005");
map.set("quoterequest.payment_amount.amount", "100.00");
map.set("quoterequest.payment_amount.currency", "USD");
map.set("quoterequest.payment_origination_country", "USA");
map.set("quoterequest.payment_type", "P2P");
    return map;   
    }
    
}
