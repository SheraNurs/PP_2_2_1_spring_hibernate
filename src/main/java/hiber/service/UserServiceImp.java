package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Transactional
    @Override
    public User get(String search) {
        return userDao.get(search);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void delete(Car car) {
        userDao.delete(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}