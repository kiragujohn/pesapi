/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.repo;

import come.epesa.model.Customer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class CustomerController {
 
	@Autowired
	CustomerRepository repository;
 
@GetMapping(value="/customers",  produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findAll(){ 
     List<Customer>cust =(List<Customer>) repository.findAll();
     return cust;
	}
    
@GetMapping(value="index")
public String profile(){
  return "Welcome to e-Pesa: The electronics Money System!!";
}
    
    
    
    @PostMapping(value="/postcustomer")
    public Customer postCustomer(@RequestBody Customer customer) {
 	repository.save(new Customer(customer.getFirstName(), customer.getLastName()));
	return customer;
     }
 
	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName) {
 
		List<Customer> customers = repository.findByLastName(lastName);
		return customers;
	}
	
    @DeleteMapping(value="/customer/{id}")
    public void deleteCustomer(@PathVariable long id){
	repository.delete(id);
}
}