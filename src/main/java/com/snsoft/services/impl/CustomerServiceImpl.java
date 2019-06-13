package com.snsoft.services.impl;

import com.snsoft.comn.ResponseCode;
import com.snsoft.comn.ServiceException;
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
    public void addCustomer(Customer customer) throws ServiceException {
        //先查一下看看ccode 是否存在
        Ccode tempCcode = ccodeMapper.selectByPrimaryKey(customer.getCode());
        //如果不等于空 表示编码已经存在 抛出异常
        if (tempCcode != null) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        //如果不存在正常添加
        Ccode ccode = new Ccode();
        ccode.setCcode(customer.getCode());
        ccode.setCname(customer.getName());
        ccodeMapper.insert(ccode);
    }

    @Override
    public void updateCustomer() throws ServiceException {


    }

    @Override
    public void deleteCustomerByCode(String code) throws ServiceException {
        ccodeMapper.deleteByPrimaryKey(code);
    }
}
