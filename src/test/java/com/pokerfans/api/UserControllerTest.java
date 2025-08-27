package com.pokerfans.api;

import com.pokerfans.controller.UserController;
import com.pokerfans.mapper.UserMapper;
import com.pokerfans.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvcTester mockMvcTester;

    @MockitoBean
    private UserServiceImpl userService;

    @MockitoBean
    private UserMapper userMapper;

    @Test
    void getUserById_success() {
        assertThat(mockMvcTester.get()
                .uri("/user/1")).hasStatusOk();
    }
}
