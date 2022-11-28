package com.example.SpringProject.Model;

import com.example.SpringProject.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name_n;
    private String email_e;
    private int age_a;
    private String phone_p;
    private String address_a;
    private Account account;

    public User(){
    }

    public User(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name_n = userEntity.getName_n();
        this.email_e = userEntity.getEmail_e();
        this.age_a = userEntity.getAge_a();
        this.phone_p = userEntity.getPhone_p();
        this.address_a = userEntity.getAddress_a();
    }
}
