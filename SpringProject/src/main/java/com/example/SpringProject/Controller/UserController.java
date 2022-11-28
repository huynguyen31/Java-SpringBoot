package com.example.SpringProject.Controller;

import com.example.SpringProject.Entity.AccountEntity;
import com.example.SpringProject.Model.Account;
import com.example.SpringProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountService accountService;

    @RequestMapping("")
    public ResponseEntity<Object> userPage(){
        try {
            return new ResponseEntity<>("Welcome User", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> addUserAccount(@RequestBody Account account){
        try {
            String encrytedPassword = bCryptPasswordEncoder.encode(account.getPassword_p()) ;
            account.setPassword_p(encrytedPassword);
            account.setRole_r("USER");
            AccountEntity accountEntity = new AccountEntity(account);
            accountService.saveAccount(accountEntity);
            return new ResponseEntity<>("User created", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
