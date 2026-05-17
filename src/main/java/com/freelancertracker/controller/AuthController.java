package com.freelancertracker.controller;

import com.freelancertracker.dto.LoginDTO;
import com.freelancertracker.dto.ResponseDTO;
import com.freelancertracker.dto.UserDTO;
import com.freelancertracker.dto.UserResponseDTO;
import com.freelancertracker.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    // Register API
    @PostMapping("/register")
    public ResponseDTO register(@Valid @RequestBody UserDTO userDTO){

        String message = authService.register(userDTO);

        return new ResponseDTO(message, null);
    }

    // Login API
    @PostMapping("/login")
    public ResponseDTO login(@Valid @RequestBody LoginDTO loginDTO){

        String token = authService.login(loginDTO);

        return new ResponseDTO("Login Successful",token);

    }

    // Get all users
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){

        return authService.getAllUsers();
    }
}
