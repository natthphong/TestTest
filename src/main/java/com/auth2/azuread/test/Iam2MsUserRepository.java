package com.auth2.azuread.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Iam2MsUserRepository extends JpaRepository<Iam2MsUser, Integer>, JpaSpecificationExecutor<Iam2MsUser> {
}