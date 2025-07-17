package com.icfesia.backend.services;

import com.icfesia.backend.models.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    UsuarioDto save(UsuarioDto usuarioDto);
    UsuarioDto update(Integer id, UsuarioDto usuarioDto);
    void deleteById(Integer id);
    UsuarioDto findById(Integer id);
    List<UsuarioDto> findAll();
}
