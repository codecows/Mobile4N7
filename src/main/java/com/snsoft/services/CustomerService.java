package com.snsoft.services;

import com.snsoft.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    void deleteCustomerByCode(String code);
}
