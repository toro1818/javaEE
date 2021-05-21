package bjtu.ebookshop.controller;

import bjtu.ebookshop.EBookShopApplication;
import bjtu.ebookshop.entity.Book;
import bjtu.ebookshop.service.BookService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
class BooksControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private BookService bookService;

    @Before
    public void before(){
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        setUp();
    }
    public void setUp(){
        Mockito.when(bookService.findALL())
                .thenReturn(new ArrayList<>());
        Mockito.when(bookService.findOne(2))
                .thenReturn(new Book());
    }


    @Test
    void books() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
        .get("/bookList"))
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    void getBookById() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
        .get("/book/2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void showAddBook() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/book/add"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void addBook() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/book/add"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void showEditBook() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/book/2/edit"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void editBook() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/book/2/edit"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteBook() throws Exception{
        mvc=MockMvcBuilders.webAppContextSetup(ctx).build();
        mvc.perform(MockMvcRequestBuilders
                .get("/book/2/delete"))
                .andExpect(status().isOk())
                .andDo(print());

    }
}