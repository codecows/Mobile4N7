package com.snsoft.services.impl;

import com.snsoft.comn.ResponseCode;
import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;
import com.snsoft.models.response.LoginResponse;
import com.snsoft.services.UserService;
import com.snsoft.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    @Resource
//    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUserId("1001");
        user1.setUsername("张三");
        User user2 = new User();
        user2.setUserId("1002");
        user2.setUsername("李四");
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    public LoginResponse login(String userName, String passwrod) throws ServiceException {
        LoginResponse loginResponse = new LoginResponse();
        User user = new User();
        user.setUserId(userName);
        user.setUsername("张三");

        loginResponse.setUser(user);
        String token = JwtUtil.getToken(userName);
        loginResponse.setToken(token);
        if (userName.equals("11")) {
            return loginResponse;
        } else {
            throw new ServiceException(ResponseCode.LgoinFailure);
        }
//        UserExample exam = new UserExample();
////        exam.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(passwrod);
////        exam.or().andUseridEqualTo(userName).andPasswordEqualTo(passwrod);
////        List<User> users = userMapper.selectByExample(exam);
////        if (CollectionUtils.isEmpty(users)) {
////            throw new ServiceException(ResponseCode.LgoinFailure);
////        }
    }
}
