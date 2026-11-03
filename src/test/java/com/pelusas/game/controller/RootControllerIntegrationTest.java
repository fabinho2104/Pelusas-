package com.pelusas.game.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Pruebas de Integración REST (MockMvc) - RootController")
class RootControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Debe retornar estado UP y metadatos de la API al consultar GET /")
    void shouldReturnRootStatus() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.application").value("Pelusas Game API"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.frontendUrl").value("http://localhost:5173"))
                .andExpect(jsonPath("$.h2ConsoleUrl").value("http://localhost:8080/h2-console"))
                .andExpect(jsonPath("$.endpoints.games").value("/api/games"))
                .andExpect(jsonPath("$.endpoints.history").value("/api/history"));
    }
}

