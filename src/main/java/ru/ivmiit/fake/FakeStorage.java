package ru.ivmiit.fake;

import ru.ivmiit.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    // переменная, которая хранит ссылку на единственный экземпляр объекта класса FakeStorage
    private static final FakeStorage storage;

    // статически инициализатор, создающий объект класса FakeStorage. Вызывается один раз при загрузке класса в JVM
    static {
        storage = new FakeStorage();
    }

    // поле-список, хранящее список пользователей системы
    private List<User> users;

    // приватный констуктор, выполняющий инициализацию списка
    private FakeStorage() {
        this.users = new ArrayList<>();
        User user = new User("Vlad", "qwerty", LocalDate.parse("1997-02-02"));
        User user1 = new User("Vlad1", "qwerty", LocalDate.parse("1997-02-02"));
        User user2 = new User("Vlad2", "qwerty", LocalDate.parse("1997-02-02"));

        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    // метод, предоставляющий доступ к объекту класса
    public static FakeStorage storage() {
        return storage;
    }

    // метод, возвращающий список пользователей
    public List<User> users() {
        return users;
    }
}
