package com.sg.kata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class TransformControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @Test
    void transform_ShouldReturnTransformedNumber() throws Exception {
        
        mockMvc.perform(get("/api/v1/transform/15"))
            .andExpect(status().isOk())
            .andExpect(content().string("OK"));
    }

}
