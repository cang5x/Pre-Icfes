package com.icfesia.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/preguntas")
public class PreguntasController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> generarPreguntas(@RequestParam(defaultValue = "5") int num,
                                                   @RequestParam(defaultValue = "Matemáticas") String tema) {

        String url = "http://localhost:8001/generar-preguntas";

        Map<String, Object> request = new HashMap<>();
        request.put("num_preguntas", num);
        request.put("tema", tema);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
