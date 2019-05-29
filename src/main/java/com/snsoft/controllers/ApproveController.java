package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.comn.ServiceException;
import com.snsoft.models.ApprovalPending;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "审批接口")
@RestController
@RequestMapping("approve")
public class ApproveController {
    @ApiOperation(value = "获取待审批数据", notes = "获取待审批数据")
    @RequestMapping(path = "getApprovalPending/{pageIndex}/{pageSize}", method = GET)
    public Response<List<ApprovalPending>> getApprovalPending(@PathVariable int pageIndex, @PathVariable int pageSize) {
        Response<List<ApprovalPending>> response = new Response<>(ResponseCode.Success);
        List<ApprovalPending> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ApprovalPending ap1 = new ApprovalPending();
            ap1.setCode("11108");
            ap1.setName("进货审批");
            ap1.setCount(7 + i);
            ApprovalPending ap2 = new ApprovalPending();
            ap2.setCode("1399991");
            ap2.setName("采购付款审批");
            ap2.setCount(2 + i);
            data.add(ap1);
            data.add(ap2);
        }

        response.setData(data);
        return response;
    }
}
