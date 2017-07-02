package com.program.user.service;

import com.program.common.utils.SecurityUtils;
import com.program.user.dao.UserMapper;
import com.program.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/26.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper ;
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/27 15:47
     * @Description:
     */
    @Override
    @Transactional
    public int createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        user.setPassword(SecurityUtils.encryptyPassword(user.getPassword()));

        return userMapper.insertSelective(user);
}
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/27 15:52
     * @params:  * @param username
     * @Description:
     */
    @Override
    public User findUserByUserName(String username) {

       return userMapper.selectByUserName(username);

    }

}

