package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.models.ApprovalPending;
import com.snsoft.models.Customer;
import com.snsoft.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "客户接口")
@RestController
@RequestMapping("ccode")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @ApiOperation(value = "获取客户数据", notes = "获取客户数据")
    @RequestMapping(path = "getCustomers", method = GET)
    public Response<List<Customer>> getCustomers() {
        Response<List<Customer>> response = new Response<>(ResponseCode.Success);
        List<Customer> customers = customerService.getCustomers();
        response.setData(customers);
        return response;
    }

    @ApiOperation(value = "添加客户数据", notes = "添加客户")
    @RequestMapping(path = "addCustomer", method = POST)
    public Response<String> addCustomer() {

        return null;
    }

    @ApiOperation(value = "删除客户数据", notes = "删除客户")
    @RequestMapping(path = "deleteCustomerByCode/{code}", method = POST)
    public Response<String> deleteCustomerByCode(@PathVariable String code) {
        customerService.deleteCustomerByCode(code);
        Response<String> response = new Response<>(ResponseCode.Success);
        return response;
    }
}
