package com.interswitch.databasefinal.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class TutorialServiceMockEnvIntegratedTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @Sql("/create-tutorial.sql")
    public void testCreateTutorial() throws Exception{
        mockMvc.perform(post("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Test 1\", " +
                        "\"description\": \"Description 1\", " +
                        "\"published\": true}"))
                .andExpect(status().isCreated());
    }
}
