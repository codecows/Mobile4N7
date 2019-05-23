package com.snsoft.controllers;

import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;
import com.snsoft.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    @RequestMapping(path = "login/{userName}/{password}", method = GET)
    public Response<String> login(@PathVariable String userName, @PathVariable String password) {
        try {
            Response<String> response = new Response<>(ResponseCode.Success);
            userService.login(userName, password);
            return response;
        } catch (ServiceException ex) {
            return ex.getResponse();
        }
    }

}
