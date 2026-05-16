package com.freelancertracker.controller;

import com.freelancertracker.dto.LoginDTO;
import com.freelancertracker.dto.ResponseDTO;
import com.freelancertracker.dto.UserDTO;
import com.freelancertracker.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody UserDTO userDTO){

        String message = authService.register(userDTO);

        return new ResponseDTO(message, null);
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginDTO loginDTO){

        String token = authService.login(loginDTO);

        return new ResponseDTO("Login Successful",token);

    }
}
