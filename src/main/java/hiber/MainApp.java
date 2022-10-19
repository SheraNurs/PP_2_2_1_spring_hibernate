package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Ivanov", "vanya@mail.ru");
        User user2 = new User("Kolya", "Petrov", "kolyan@mail.ru");
        User user3 = new User("Masha", "Sidorova", "Manya@mail.ru");

        Car car1 = new Car("BMW", 540);
        Car car2 = new Car("Opel", 100);
        Car car3 = new Car("Audi", 4);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        userService.delete(user2);

        User user = userService.get("BMW");
        System.out.println(user.getFirstName());

//        System.out.println(user1.getCar());
//
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = "+user.getId());
//            System.out.println("First Name = "+user.getFirstName());
//            System.out.println("Last Name = "+user.getLastName());
//            System.out.println("Email = "+user.getEmail());
//            System.out.println();
//        }

        context.close();
    }
}
