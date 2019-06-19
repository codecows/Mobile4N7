package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.models.ApprovalPendingGroup;
import com.snsoft.models.ApprovalPendingItem;
import com.snsoft.services.ApproveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "审批接口")
@RestController
@RequestMapping("approve")
public class ApproveController {
    @Resource
    private ApproveService approveService;

    @ApiOperation(value = "获取待审批数据(分组)", notes = "获取待审批数据(分组)")
    @RequestMapping(path = "getApprovalPending/{userId}", method = GET)
    public Response<List<ApprovalPendingGroup>> getApprovalPending(@PathVariable String userId) {
        Response<List<ApprovalPendingGroup>> response = new Response<>(ResponseCode.Success);
        List<ApprovalPendingGroup> data = approveService.getPendingGroups(userId);
        response.setData(data);
        return response;
    }

    @ApiOperation(value = "获取待审批数据", notes = "获取待审批数据")
    @RequestMapping(path = "getApprovalPendingItems/{code}", method = GET)
    public Response<List<ApprovalPendingItem>> getApprovalPendingItems(@PathVariable String code) {
        Response<List<ApprovalPendingItem>> response = new Response<>(ResponseCode.Success);
        List<ApprovalPendingItem> data = approveService.getPendingItems(code);
        response.setData(data);
        return response;
    }

    @ApiOperation(value = "审批", notes = "审批")
    @RequestMapping(path = "approve/{id}/{result}/{userName}", method = GET)
    public Response<String> approve(
            @PathVariable String id, @PathVariable String result, @PathVariable String userName) {
        Response<String> response = new Response<>(ResponseCode.Success);
        approveService.approve(id, userName, result.equals("Y") ? "同意" : "驳回");
        return response;
    }
}
