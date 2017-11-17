/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.contoller;

import com.mastercard.api.crossborder.Quotes;
import com.pesa.epesa.contoller.helpers.Ref_generator;
import com.pesa.epesa.mastercard.moneySend.Mastercard_quote_request;
import com.pesa.epesa.mastercard.repo.CustomerRepository;
import come.epesa.mastercard.model.Customer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static javassist.CtMethod.ConstParameter.string;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class EPesaController {
 
@Autowired
CustomerRepository repository;

    @RequestMapping("/")
    public String welcome(){
      return "Welcome to e-Pesa money transfer system <p><h1>End Points:<p/><p><h1>/quote</h1><p/>";
    }
 
    @GetMapping(value="/customers",  produces=MediaType.APPLICATION_JSON_VALUE)
        public List<Customer> findAll(){ 
         List<Customer>cust =(List<Customer>) repository.findAll();
         return cust;
            }

   @RequestMapping(value="/quote", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)  
     public Quotes quote(@RequestParam(value = "userTokenID", required=false) Integer userTokenID,@RequestParam(value = "hashCode", required=false) String hashCode,@RequestParam(value = "object", required=false) Object object) {
        Ref_generator refgen=new Ref_generator();
          Mastercard_quote_request quote=new Mastercard_quote_request();
            return quote.send_request(refgen.generate());
     }   
}