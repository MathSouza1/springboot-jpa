package com.matheuscardoso.course.config;

import com.matheuscardoso.course.entities.Category;
import com.matheuscardoso.course.entities.Order;
import com.matheuscardoso.course.entities.User;
import com.matheuscardoso.course.enumerators.OrderStatus;
import com.matheuscardoso.course.repositories.CategoryRepository;
import com.matheuscardoso.course.repositories.OrderRepository;
import com.matheuscardoso.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User secondUser = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser));

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, firstUser);
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));

        Category firstCategory = new Category(null, "Eletronics");
        Category secondCategory = new Category(null, "Books");
        Category thirdCategory = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(firstCategory, secondCategory, thirdCategory));

    }
}
