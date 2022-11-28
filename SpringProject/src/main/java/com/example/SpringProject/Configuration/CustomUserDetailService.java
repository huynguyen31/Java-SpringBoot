package com.example.SpringProject.Configuration;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;
import com.example.SpringProject.Repository.AccountRepository;
import com.example.SpringProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findByUsernameU(username);
        if (accountEntity == null){
            throw new UsernameNotFoundException(username);
        }
        Account account = new Account(accountEntity);
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setAccount(account);
        return userDetails;
    }
}
