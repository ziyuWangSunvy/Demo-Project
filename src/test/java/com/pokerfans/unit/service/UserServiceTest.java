package com.pokerfans.unit.service;

import com.pokerfans.entity.User;
import com.pokerfans.mapper.UserMapper;
import com.pokerfans.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        User user = new User();
        user.setUsername("Alice");
        user.setEmail("alice@example.com");

        Mockito.doAnswer(invocation -> {
            user.setId(1L); // 模拟自增 ID
            return 1;
        }).when(userMapper).insert(user);

        User saved = userService.createUser(user);
        assertNotNull(saved.getId());
        assertEquals("Alice", saved.getUsername());
    }
}
