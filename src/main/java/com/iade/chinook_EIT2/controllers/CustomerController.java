package com.iade.chinook_EIT2.controllers;

import java.util.Optional;

import com.iade.chinook_EIT2.models.repositories.CustomerRepository;
import com.iade.chinook_EIT2.models.views.InvoiceStatistcsView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/customers")
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/statistics/invoices", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<InvoiceStatistcsView> getInvoiceStatistics() {
        logger.info("Sending all albums");
        return customerRepository.getInvoiceStatistics();
    }

}
