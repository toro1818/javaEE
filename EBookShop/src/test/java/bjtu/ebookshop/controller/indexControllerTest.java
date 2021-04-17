package bjtu.ebookshop.controller;

import bjtu.ebookshop.entity.Book;
import bjtu.ebookshop.service.BookService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class indexControllerTest {

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
    void index() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/index"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}