package com.moon.mybatis.mapper;

import com.moon.mybatis.model.UserPO;

import java.util.List;

public interface UserDao {

    List<UserPO> getUserList();

    void insert(UserPO user);

    void updateUser(UserPO user);

    void deleteUser(UserPO user);

    UserPO selectUserById(int userId);
}