package top.cmoon.blog.userservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import top.cmoon.blog.userservice.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {


    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController())
                .build();

    }

    @Test
    public void test_get_user_by_id() throws Exception {
        int id = 1;
        this.mockMvc.perform(get("/users/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));

    }


}
