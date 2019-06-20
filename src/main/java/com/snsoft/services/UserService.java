package com.snsoft.services;


import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;
import com.snsoft.models.response.LoginResponse;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    LoginResponse login(String userName, String passwrod) throws ServiceException;
}
