package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.models.ApprovalPending;
import com.snsoft.models.Voucher;
import com.snsoft.services.VoucherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "凭证接口")
@RestController
@RequestMapping("voucher")
public class VoucherController {
    @Resource
    private VoucherService voucherService;

    @ApiOperation(value = "获取凭证", notes = "获取凭证")
    @RequestMapping(path = "getApprovalPending/{bCode}/{year}/{month}", method = GET)
    public Response<List<Voucher>> getVouchers(
            @PathVariable String bCode,
            @PathVariable int year,
            @PathVariable int month) {
        Response<List<Voucher>> response = new Response<>(ResponseCode.Success);
        List<Voucher> vouchers = voucherService.findVoucher(bCode, year, month);
        response.setData(vouchers);
        return response;
    }

    @ApiOperation(value = "一级审批凭证", notes = "一级审批凭证")
    @RequestMapping(path = "approve/{hId}", method = GET)
    public Response<List<Voucher>> getVouchers(@PathVariable String hId) {
        Response<List<Voucher>> response = new Response<>(ResponseCode.Success);
        voucherService.approveVoucher(hId);
        return response;
    }
}
