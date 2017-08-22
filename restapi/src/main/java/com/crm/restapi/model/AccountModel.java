package com.crm.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_s_account")
public class AccountModel extends BaseModel {
    @Column(name = "name")
    private String name;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "plat")
    private String plat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
}
