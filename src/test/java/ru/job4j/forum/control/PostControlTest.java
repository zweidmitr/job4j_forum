package ru.job4j.forum.control;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void shouldReturnDefaultSave() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name", "qwerty"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getName(), is("qwerty"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultUpdate() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name", "asdf"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        this.mockMvc.perform(post("/save")
                        .param("name", "jkl;"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> arg = ArgumentCaptor.forClass(Post.class);
        verify(postService, times(2)).save(arg.capture());
        MatcherAssert.assertThat(arg.getValue().getId(), is(0));
        MatcherAssert.assertThat(arg.getValue().getName(), is("jkl;"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/read")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("read"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageUpdate() throws Exception {
        this.mockMvc.perform(get("/update")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }
}