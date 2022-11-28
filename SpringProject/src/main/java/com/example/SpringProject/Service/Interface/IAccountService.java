package com.example.SpringProject.Service.Interface;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> getAllAccount();
    public Account findAccountById();
    public void saveAccount(AccountEntity accountEntity);
    public void deleteAccount(long id);
}
