package com.nowcoder.synergy.service;

import com.nowcoder.synergy.dao.UserMapper;
import com.nowcoder.synergy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

}
