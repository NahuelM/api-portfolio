package com.own.api.service.Implementation;

import com.own.api.model.User;
import com.own.api.model.UserRole;
import com.own.api.repository.imp.CategoryRepository;
import com.own.api.repository.imp.ProductRepository;
import com.own.api.repository.imp.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void run(ApplicationArguments args) {
        userRepository.save(new User(1L, "test@email.com", "12345678", "Pedro", UserRole.USER, null));
        LOGGER.info("Data loaded");
    }
}