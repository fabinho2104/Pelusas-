package com.pelusas.game.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> rootStatus() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("application", "Pelusas Game API");
        response.put("version", "1.0.0");
        response.put("frontendUrl", "http://localhost:5173");
        response.put("h2ConsoleUrl", "http://localhost:8080/h2-console");
        response.put("endpoints", Map.of(
                "games", "/api/games",
                "history", "/api/history"
        ));
        return ResponseEntity.ok(response);
    }
}

