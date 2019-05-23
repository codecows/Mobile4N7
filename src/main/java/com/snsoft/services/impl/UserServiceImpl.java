package com.snsoft.services.impl;

import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;
import com.snsoft.services.UserService;
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
        user1.setUserid("1001");
        user1.setUsername("张三");
        User user2 = new User();
        user2.setUserid("1002");
        user2.setUsername("李四");
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    public void login(String userName, String passwrod) throws ServiceException {
//        UserExample exam = new UserExample();
////        exam.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(passwrod);
////        exam.or().andUseridEqualTo(userName).andPasswordEqualTo(passwrod);
////        List<User> users = userMapper.selectByExample(exam);
////        if (CollectionUtils.isEmpty(users)) {
////            throw new ServiceException(ResponseCode.LgoinFailure);
////        }
    }
}
