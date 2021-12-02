package com.example.warehouse.component;

import com.example.warehouse.entity.Role;
import com.example.warehouse.entity.User;
import com.example.warehouse.entity.enums.Permission;
import com.example.warehouse.repository.RoleRepository;
import com.example.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {

            Permission[] values = Permission.values();
            Set<Permission> permissionSet = new HashSet<Permission>(Arrays.asList(values));

            Role admin = roleRepository.save(new Role(1, "ADMIN", true, permissionSet));

            Role user = roleRepository.save(new Role(2, "USER", true, new HashSet<>(
                    Arrays.asList(
                            Permission.READ_CATEGORY,
                            Permission.READ_PRODUCT,
                            Permission.READ_WAREHOUSE,
                            Permission.READ_USERS
                    ))));

            Role manager = roleRepository.save(new Role(3, "MANAGER", true,
                    new HashSet<>(
                            Arrays.asList(
                                    Permission.ADD_CATEGORY,
                                    Permission.ADD_PRODUCT,
                                    Permission.ADD_WAREHOUSE,
                                    Permission.ADD_USER
                            )
                    )));

            userRepository.save(new User("SuperAdmin",
                    "super",
                    "996921836",
                    passwordEncoder.encode("123"),
                    admin,
                    true));


        }
    }

}
