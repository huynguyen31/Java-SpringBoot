package com.example.SpringProject.Repository;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByUsernameU(String username);
}
