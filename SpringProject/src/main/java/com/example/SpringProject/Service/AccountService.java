package com.example.SpringProject.Service;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;
import com.example.SpringProject.Repository.AccountRepository;
import com.example.SpringProject.Service.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        try {
            List<Account> listAccount = new ArrayList<>();
            List<AccountEntity> listAccountEntity = accountRepository.findAll();
            for (AccountEntity temp: listAccountEntity) {
                Account account = new Account(temp);
                listAccount.add(account);
            }
            return listAccount;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account findAccountById() {
        return null;
    }

    @Override
    public void saveAccount(AccountEntity accountEntity) {
        try {
            accountRepository.save(accountEntity);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(long id) {

    }
}
