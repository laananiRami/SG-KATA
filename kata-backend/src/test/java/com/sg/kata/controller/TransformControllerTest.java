package com.sg.kata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sg.kata.service.NumberTransformService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NumberTransformController.class)
public class TransformControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NumberTransformService service;

    @Test
    void transform_ShouldReturnTransformedNumber() throws Exception {
        
         when(service.transform(15)).thenReturn("FOOBAR");

        mockMvc.perform(get("/api/v1/transform/15"))
            .andExpect(status().isOk())
            .andExpect(content().json("{result:FOOBAR}"));

    }

}
