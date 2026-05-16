package com.freelancertracker.service;

import com.freelancertracker.dto.LoginDTO;
import com.freelancertracker.dto.UserDTO;
import com.freelancertracker.model.User;
import com.freelancertracker.repository.UserRepository;
import com.freelancertracker.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(UserDTO userDTO) {

        boolean userExists = userRepository
                .findByEmail(userDTO.getEmail())
                .isPresent();

        if(userExists){
            throw new RuntimeException("User already exists!");
        }

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        user.setPassword(
                passwordEncoder.encode(userDTO.getPassword())
        );

        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(LoginDTO loginDTO) {

        User user = userRepository
                .findByEmail(loginDTO.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found!"));

        boolean passwordMatches = passwordEncoder.matches(
                loginDTO.getPassword(),
                user.getPassword()
        );

        if(!passwordMatches){
            throw new RuntimeException("Invalid Credentials!");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
