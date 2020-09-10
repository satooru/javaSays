package com.satooru.javaSays.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.satooru.javaSays.controller.QuoteController;
import com.satooru.javaSays.model.Quote;
import com.satooru.javaSays.service.QuoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteControllerTest {
    @Mock
    private QuoteService quoteService;

    @InjectMocks
    private QuoteController quoteController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(quoteController).build();
    }

    @Test
    public void findRandomQuoteTest() throws Exception {
        when(quoteService.findRandomQuote()).thenReturn(new Quote("Test"));
//        given(quoteService.findAll()).willReturn(new ArrayList<>());
//        doNothing().when(quoteService.deleteQuote(BDDMockito.anyString()));
//        Mockito.doNothing().when(quoteService).deleteQuote(BDDMockito.anyString());
        
//        given(quoteService.findRandomQuote()).willReturn(new Quote("Test"));

        mockMvc.perform(get("/"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.quote").exists())
               .andExpect(jsonPath("$.quote", is("Test")));
    }

    /*
    @Test
    public void findLatestQuoteTest() throws Exception {
        mockMvc.perform(get("/latest"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.quote").exists());
    }

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/all"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void saveQuoteTest() throws Exception {
        mockMvc.perform(post("/")
                       .contentType("text/plain")
                       .content("testing"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string("Quote added successfully"));
    }

    @Test
    public void deleteQuoteTest() throws Exception {
        mockMvc.perform(delete("/")
                       .contentType("text/plain")
                       .content("testing"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string("Quote deleted successfully"));
    }
    */
}
