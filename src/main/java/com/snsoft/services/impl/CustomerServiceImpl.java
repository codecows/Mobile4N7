package com.snsoft.services.impl;

import com.snsoft.dao.entities.Ccode;
import com.snsoft.dao.entities.CcodeExample;
import com.snsoft.dao.mappers.CcodeMapper;
import com.snsoft.models.Customer;
import com.snsoft.services.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CcodeMapper ccodeMapper;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<Ccode> codes = ccodeMapper.selectByExample(null);
        for (Ccode ccode : codes) {
            Customer customer = new Customer();
            customer.setCode(ccode.getCcode());
            customer.setName(ccode.getCname());
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomerByCode(String code) {
        ccodeMapper.deleteByPrimaryKey(code);
    }
}
