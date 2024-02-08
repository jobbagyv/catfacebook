package com.vince.cicafacebook.repositories.user;

import com.vince.cicafacebook.entities.User;

import java.util.List;

public interface UserRepositoryCustom {
    public User findEager(Long id);
    public List<User> findAllEager();
}
