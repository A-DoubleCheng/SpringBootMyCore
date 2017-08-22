package com.crm.restapi.service;

import com.crm.restapi.model.UserModel;

public interface UserService {
    UserModel byUsername(String username);
}
