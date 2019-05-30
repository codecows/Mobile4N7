package com.snsoft.controllers;

import com.snsoft.dao.entities.Acode;
import com.snsoft.dao.mappers.AcodeMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private AcodeMapper acodeMapper;

    @RequestMapping(path = "getDetonators", method = GET)
    public List<Acode> getUsers() {
        return acodeMapper.selectByExample(null);
    }

}
