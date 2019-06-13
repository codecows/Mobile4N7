package com.snsoft.services;

import com.snsoft.comn.ServiceException;
import com.snsoft.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void addCustomer(Customer customer) throws ServiceException;

    void updateCustomer() throws ServiceException;

    void deleteCustomerByCode(String code) throws ServiceException;
}
