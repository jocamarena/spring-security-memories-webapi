package org.memories.webapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OpenAiServiceTest {

    @Autowired
    private OpenAiService openAiService;

/*    @Test
    void getResponse() {
        String prompt = "What is the capital of France?";
        String response = openAiService.getResponse(prompt);
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertTrue(response.contains("Paris"));
    }*/
}