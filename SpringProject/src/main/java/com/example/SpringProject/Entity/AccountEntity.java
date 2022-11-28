package com.example.SpringProject.Entity;


import com.example.SpringProject.Model.Account;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account_abc")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String usernameU;

    @Column
    @NotNull
    private String password_p;

    @Column
    @NotNull
    private String role_r;

    public AccountEntity(){}

    public AccountEntity(String username_u, String password_p, String role_r){
        this.usernameU = username_u;
        this.password_p = password_p;
        this.role_r = role_r;
    }

    public AccountEntity(Account account){
        this.usernameU = account.getUsername_u();
        this.password_p = account.getPassword_p();
        this.role_r = account.getRole_r();
    }
}
