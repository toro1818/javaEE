package bjtu.ebookshop.controller;

import bjtu.ebookshop.service.BookService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class loginControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private BookService bookService;

    @Before
    public void before(){
        mvc= MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void login() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .post("/user/login").param("username","admin")
        .param("password","123456"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void logout() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/user/logout"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}