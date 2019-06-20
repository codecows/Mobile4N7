package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;
import com.snsoft.models.request.LoginRequest;
import com.snsoft.models.response.LoginResponse;
import com.snsoft.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(description = "用户接口")
@RestController
@RequestMapping("users")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "获取用户", notes = "获取用户")
    @RequestMapping(path = "getUsers", method = GET)
    public Response<List<User>> getUsers() {
        return new Response<>(ResponseCode.Success, userService.getUsers());
    }

    @ApiOperation(value = "登录", notes = "登录,返回token")
    @RequestMapping(path = "login", method = POST)
    public Response<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Response<LoginResponse> response = new Response<>(ResponseCode.Success);
            LoginResponse info = userService.login(loginRequest.getUserId(), loginRequest.getPassword());
            response.setData(info);
            return response;
        } catch (ServiceException ex) {
            return ex.getResponse();
        }
    }

}
