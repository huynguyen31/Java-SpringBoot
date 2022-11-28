package com.example.SpringProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

@Data
@AllArgsConstructor
public class Login {
    private String username;
    private String password;

    public Login(){};
}
