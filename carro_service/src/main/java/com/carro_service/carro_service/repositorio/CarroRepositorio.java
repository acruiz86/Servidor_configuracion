package com.carro_service.carro_service.repositorio;

import com.carro_service.carro_service.entidades.Carro;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public  interface CarroRepositorio extends JpaRepository<Carro, Integer>{
    List<Carro> findByusuarioId(int usuarioID);
}
