package ru.ivmiit.repositories;

import ru.ivmiit.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void save(User user);
    boolean ifExist(String name, String password);
}

