package com.example.SpringProject.Controller;

import com.example.SpringProject.Configuration.CustomUserDetails;
import com.example.SpringProject.Configuration.JwtProvider;
import com.example.SpringProject.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody Login login){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
            return new ResponseEntity<Object>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Account does not exist", HttpStatus.FORBIDDEN);
        }
    }
}
