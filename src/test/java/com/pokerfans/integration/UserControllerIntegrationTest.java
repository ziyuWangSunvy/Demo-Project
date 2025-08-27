package com.pokerfans.integration;

import com.pokerfans.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 集成测试 UserController CRUD 接口
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvcTester mockMvcTester;

    private String requestBody;

    @BeforeEach
    void setUp() {
        requestBody = """
                {
                    "username": "testuser",
                    "email": "testuser@example.com"
                }
                """;
    }

    @Test
    void showUserSettings_whenUserExists_returnUserData() {
        var exchange = mockMvcTester.get().uri("/users/1").exchange();
        assertThat(exchange)
                .hasStatusOk()
                .hasViewName("index")
                .model()
                .containsKey("user")
                .extractingByKey("user")
                .isInstanceOf(User.class)
                .satisfies(user -> {
                    User u = (User) user;
                    assertThat(u.getId()).isEqualTo(1L);
                    assertThat(u.getUsername()).isEqualTo("alice");
                    assertThat(u.getEmail()).isEqualTo("alice@example.com");
                });
    }


}
