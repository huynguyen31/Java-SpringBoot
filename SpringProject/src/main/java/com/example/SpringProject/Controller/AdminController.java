package com.example.SpringProject.Controller;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;
import com.example.SpringProject.Model.User;
import com.example.SpringProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AccountService accountService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("")
    public ResponseEntity<Object> adminPage(){
        try {
            List<Account> listAccount = accountService.getAllAccount();
            return new ResponseEntity<>("Welcome admin", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> addAdminAccount(@RequestBody Account account){
        try {
            String encrytedPassword = bCryptPasswordEncoder.encode(account.getPassword_p()) ;
            account.setPassword_p(encrytedPassword);
            account.setRole_r("ADMIN");
            AccountEntity accountEntity = new AccountEntity(account);
            accountService.saveAccount(accountEntity);
            return new ResponseEntity<>("Admin created", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
