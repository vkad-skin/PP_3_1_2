package com.laskin.springboot.pp_3_1_2.dao;


import com.laskin.springboot.pp_3_1_2.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUserById(int id);
}
