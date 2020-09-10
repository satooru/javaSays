package com.satooru.javaSays;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void findRandomQuoteTest() throws Exception {
        mockMvc.perform(get("/"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.quote").exists());
    }

    @Test
    @Order(2)
    public void findLatestQuoteTest() throws Exception {
        mockMvc.perform(get("/latest"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.quote").exists());
    }

    @Test
    @Order(3)
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/all"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }

    @Test
    @Order(4)
    public void saveQuoteTest() throws Exception {
        mockMvc.perform(post("/")
                       .contentType("text/plain")
                       .content("testing"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string("Quote added successfully"));
    }

    @Test
    @Order(5)
    public void deleteQuoteTest() throws Exception {
        mockMvc.perform(delete("/")
                       .contentType("text/plain")
                       .content("testing"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string("Quote deleted successfully"));
    }
}
