package com.iade.chinook_EIT2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="customerid")
    private int id;
    @Column(name="firstname")
    private String fname;
    @Column(name="lastname")
    private String lname;
   
    public Customer() {}

    public int getId() {
        return id;
    }

 
    public String getFname() {
        return fname;
    }

 
    public String getLname() {
        return lname;
    }

 
    
}
