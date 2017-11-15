/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.mastercard.repo;

import come.epesa.mastercard.model.Customer;
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
  
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}