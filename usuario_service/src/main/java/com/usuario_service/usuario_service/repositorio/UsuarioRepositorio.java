package com.usuario_service.usuario_service.repositorio;

import com.usuario_service.usuario_service.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer>{
    
}
