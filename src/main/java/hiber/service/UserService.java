package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void add(Car car);

    User get(String search);

    void delete(User user);

    void delete(Car car);
    List<User> listUsers();
}
