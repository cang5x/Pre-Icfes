package com.icfesia.backend.services.impl;

import com.icfesia.backend.entities.Usuario;
import com.icfesia.backend.models.UsuarioDto;
import com.icfesia.backend.repository.UsuarioRepository;
import com.icfesia.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    private UsuarioDto toDto(Usuario u) {
        UsuarioDto d = new UsuarioDto();
        d.setId(u.getId());
        d.setNombre(u.getNombre());
        d.setApellido(u.getApellido());
        d.setEmail(u.getEmail());
        d.setPassword(u.getPassword());
        d.setTelefono(u.getTelefono());
        return d;
    }

    private Usuario toEntity(UsuarioDto d) {
        Usuario u = new Usuario();
        u.setId(d.getId());
        u.setNombre(d.getNombre());
        u.setApellido(d.getApellido());
        u.setEmail(d.getEmail());
        u.setPassword(d.getPassword());
        u.setTelefono(d.getTelefono());
        return u;
    }

    @Override
    public UsuarioDto save(UsuarioDto dto) {
        Usuario saved = repo.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public UsuarioDto update(Integer id, UsuarioDto dto) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setTelefono(dto.getTelefono());
        Usuario updated = repo.save(u);
        return toDto(updated);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public UsuarioDto findById(Integer id) {
        return repo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
    }

    @Override
    public List<UsuarioDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
