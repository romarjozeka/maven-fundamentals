package com.example.modeldao;

import com.example.daoapi.UserDaoApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements UserDaoApi <User>{


    private List<User> users = new ArrayList<>();



    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
