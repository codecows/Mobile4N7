package com.snsoft.controllers;


import com.snsoft.comn.Response;
import com.snsoft.comn.ResponseCode;
import com.snsoft.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(description = "授权接口")
@RestController
@RequestMapping("auth")
public class AuthController {

    @ApiOperation(value = "获取TOKEN",
            notes = "获取TOKEN,返回获取TOKEN",
            response = String.class)
    @RequestMapping(path = "getToken/{name}", method = GET)
    public Response<String> getToken(@PathVariable String name) {
        if (StringUtils.isEmpty(name)) {
            return new Response<>(ResponseCode.Unauthorized, "用户名不能为空!", null);
        }
        String token = JwtUtil.getToken(name);
        return new Response<>(ResponseCode.Success, "success", token);
    }
}
