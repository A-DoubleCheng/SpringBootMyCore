package com.crm.restapi.repository;

import com.crm.restapi.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>, JpaSpecificationExecutor {
    @Query("select a from AccountModel a where a.userId = ?1")
    List<AccountModel> listByUserId(Long userId);//通过userid查找list
    @Query("select distinct(a.plat) from AccountModel a where a.userId = ?1")
    List<String> listPlatByUserId(Long userId);//通过userid获得平台
    @Query("select a from AccountModel a where a.userId = ?1 and a.plat = ?2")
    List<AccountModel> listByUserId_Plat(Long userId, String plat);//通过userid、plat获得qq账号

}
