package com.iade.chinook_EIT2.models.repositories;

import com.iade.chinook_EIT2.models.Customer;
import com.iade.chinook_EIT2.models.views.InvoiceStatistcsView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    String statsQuery = "select customer.CustomerId  AS id, FirstName, LastName, "+
    "SUM(invoiceline.Quantity) AS total, SUM(invoiceline.Quantity*invoiceline.UnitPrice) AS cost "+
    "FROM customer, invoice, invoiceline "+
    "WHERE customer.CustomerId = invoice.CustomerId "+
    "AND invoice.InvoiceId = invoiceline.InvoiceId "+
    "group by customer.CustomerId";
    
    @Query(value=statsQuery, nativeQuery=true)
    Iterable<InvoiceStatistcsView> getInvoiceStatistics();
}
