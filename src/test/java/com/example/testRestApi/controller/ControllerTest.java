package com.example.testRestApi.controller;

import com.example.testRestApi.model.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    void getUser() throws Exception {
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders
                .get("/user")
                .accept(MediaType.APPLICATION_JSON))
                        .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                "{\"id\":1,\"name\":\"name\",\"surName\":\"surname\",\"email\":\"email\",\"imageUrl\":\"imageUrl\",\"status\":\"offline\"}"
        );

        /*
        Users user = new Users();
        user.setName("name");
        user.setSurName("surName");
        user.setEmail("email");
        user.setImageUrl("imageUrl");
        user.setStatus("status");
         */

    }
}