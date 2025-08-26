package com.pokerfans.mapper;

import com.pokerfans.entity.User;
import com.pokerfans.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Rollback
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testCRUD() {
        // Create
        User user = new User();
        user.setUsername("Bob");
        user.setEmail("bob@example.com");
        userService.createUser(user);
        assertNotNull(user.getId());

        // Read
        User found = userService.getUserById(user.getId());
        assertEquals("Bob", found.getUsername());

        // Update
        user.setUsername("Bobby");
        userService.updateUser(user);
        User updated = userService.getUserById(user.getId());
        assertEquals("Bobby", updated.getUsername());

        // Delete
        userService.deleteUser(user.getId());
        User deleted = userService.getUserById(user.getId());
        assertNull(deleted);
    }
}
