package com.iade.chinook_EIT2.models.repositories;

import com.iade.chinook_EIT2.models.Customer;
import com.iade.chinook_EIT2.models.views.InvoiceStatistcsView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    String statsQuery = "select Customer.CustomerId  AS id, FirstName, LastName, "+
    "SUM(InvoiceLine.Quantity) AS total, SUM(InvoiceLine.Quantity*InvoiceLine.UnitPrice) AS cost "+
    "FROM Customer, Invoice, InvoiceLine "+
    "WHERE Customer.CustomerId = Invoice.CustomerId "+
    "AND Invoice.InvoiceId = InvoiceLine.InvoiceId "+
    "group by Customer.CustomerId";
    
    @Query(value=statsQuery, nativeQuery=true)
    Iterable<InvoiceStatistcsView> getInvoiceStatistics();
}
