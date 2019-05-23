package com.snsoft.services;


import com.snsoft.comn.ServiceException;
import com.snsoft.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void login(String userName, String passwrod) throws ServiceException;
}
