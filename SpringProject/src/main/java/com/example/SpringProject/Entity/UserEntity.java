package com.example.SpringProject.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_abc")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String name_n;

    @Column
    @NotNull
    private String email_e;

    @Column
    @NotNull
    private int age_a;

    @Column
    @NotNull
    private String phone_p;

    @Column
    @NotNull
    private String address_a;

    @OneToOne
    @JoinColumn(name = "account_entity_id")
    private AccountEntity accountEntity;

    public UserEntity(){}

    public UserEntity(String name_n, String email_e, int age_a, String phone_p, String address_a){
        this.name_n = name_n;
        this.email_e = email_e;
        this.age_a = age_a;
        this.phone_p = phone_p;
        this.address_a = address_a;
    }
}
