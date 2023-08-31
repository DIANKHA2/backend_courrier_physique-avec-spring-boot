package com.webgram.service;

import com.webgram.entity.Role;
import com.webgram.entity.User;
import com.webgram.pojo.AuthReponse;
import com.webgram.pojo.LoginRequest;

public interface IAuthService {
    User register (User user);
    AuthReponse login(LoginRequest request);
}

