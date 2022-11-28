package com.example.SpringProject.Model;

import com.example.SpringProject.Entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private long id;
    private String username_u;
    private String password_p;
    private String role_r;

    public Account(){}

    public Account(AccountEntity accountEntity){
        this.id = accountEntity.getId();
        this.username_u = accountEntity.getUsernameU();
        this.password_p = accountEntity.getPassword_p();
        this.role_r = accountEntity.getRole_r();
    }
}