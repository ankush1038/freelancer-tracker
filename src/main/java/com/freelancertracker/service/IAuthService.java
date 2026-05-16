package com.freelancertracker.service;

import com.freelancertracker.dto.LoginDTO;
import com.freelancertracker.dto.UserDTO;

public interface IAuthService {

    String register(UserDTO userDTO);

    String login(LoginDTO loginDTO);
}
