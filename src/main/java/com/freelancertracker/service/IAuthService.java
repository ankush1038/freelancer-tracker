package com.freelancertracker.service;

import com.freelancertracker.dto.LoginDTO;
import com.freelancertracker.dto.UserDTO;
import com.freelancertracker.dto.UserResponseDTO;

import java.util.List;

public interface IAuthService {

    String register(UserDTO userDTO);

    String login(LoginDTO loginDTO);

    List<UserResponseDTO> getAllUsers();
}
