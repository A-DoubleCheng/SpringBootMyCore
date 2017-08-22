package com.crm.restapi.service.Impl;

import com.crm.restapi.model.AccountModel;
import com.crm.restapi.repository.AccountRepository;
import com.crm.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountModel> listByUserId(Long userId) {
        List<AccountModel> accountModelList = accountRepository.listByUserId(userId);
        return accountModelList;
    }
}
