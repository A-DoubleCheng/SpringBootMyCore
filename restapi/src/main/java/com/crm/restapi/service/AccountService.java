package com.crm.restapi.service;

import com.crm.restapi.model.AccountModel;

import java.util.List;

public interface AccountService {
    List<AccountModel> listByUserId(Long userId);
}
