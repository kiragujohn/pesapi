/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pesa.epesa.contoller.helpers;

import java.util.Random;

/**
 *
 * @author User
 */
public class Ref_generator {
    public String generate() {
    Random r = new Random( System.currentTimeMillis() );
    int num= 10000 + r.nextInt(20000);
    return "07"+num;
}
    
}
