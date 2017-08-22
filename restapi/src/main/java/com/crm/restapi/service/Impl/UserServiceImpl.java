package com.crm.restapi.service.Impl;

import com.crm.restapi.model.UserModel;
import com.crm.restapi.repository.UserRepository;
import com.crm.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel byUsername(String username) {
        return userRepository.byUsername(username);
    }
}
