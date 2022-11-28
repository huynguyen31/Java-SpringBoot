package com.example.SpringProject.Configuration;

import com.example.SpringProject.Model.Account;
import com.example.SpringProject.Repository.AccountRepository;
import com.example.SpringProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.ObjectError;

import java.util.*;

public class CustomUserDetails  implements UserDetails {
    @Autowired
    AccountService accountService;
    private Account account;

    private static final long serialVersionUID = 1L;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(account.getRole_r()));
            return authorities;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getPassword() {
        return account.getPassword_p();
    }

    @Override
    public String getUsername() {
        return account.getUsername_u();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
