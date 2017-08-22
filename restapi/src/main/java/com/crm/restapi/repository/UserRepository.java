package com.crm.restapi.repository;

import com.crm.restapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor {
    @Query("select u from UserModel u where u.username = ?1")
    UserModel byUsername(String username);
}
