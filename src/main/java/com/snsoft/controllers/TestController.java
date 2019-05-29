package com.snsoft.controllers;

import com.snsoft.dao.entities.Detonator;
import com.snsoft.dao.mappers.DetonatorMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private DetonatorMapper detonatorMapper;

    @RequestMapping(path = "getDetonators", method = GET)
    public List<Detonator> getUsers() {
        return detonatorMapper.selectByExample(null);
    }

}
