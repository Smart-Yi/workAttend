package com.program.user.service;

import com.program.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/26.
 */
public interface IUserService {

    int createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    User findUserByUserName(String username);
}
