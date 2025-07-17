package com.icfesia.backend.controllers;

import com.icfesia.backend.models.UsuarioDto;
import com.icfesia.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDto getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    /**
     * Ahora recibe el DTO directamente (se mapea desde form-urlencoded).
     */
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto create(UsuarioDto dto) {
        return service.save(dto);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto update(@PathVariable Integer id, UsuarioDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
