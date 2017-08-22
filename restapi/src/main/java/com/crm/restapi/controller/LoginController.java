package com.crm.restapi.controller;

import com.crm.restapi.model.UserModel;
import com.crm.restapi.param.LoginParam;
import com.crm.restapi.result.ApiResult;
import com.crm.restapi.service.AccountService;
import com.crm.restapi.service.UserService;
import com.crm.restapi.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @Value("${token.crm.time}")
    private Long exptime;
    @Value("${token.crm.secret}")
    private String secret;

    @RequestMapping(method = RequestMethod.POST)
    public ApiResult getToken(@RequestBody LoginParam loginParam){
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        Map map = new HashMap();

        UserModel user = userService.byUsername(username);
        String token = null;
        if(user != null && (password).equals(user.getPassword())){
            token = JWTUtil.createJWT(loginParam.getUsername(), user.getId().toString(), "client", "server", exptime, secret);
            map.put("account", accountService.listByUserId(user.getId()));
            map.put("XToken", token);
            return new ApiResult().success(map);
        }
        return new ApiResult().failure();
    }

}
