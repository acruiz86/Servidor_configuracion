package com.carro_service.carro_service.service;

import com.carro_service.carro_service.repositorio.CarroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.carro_service.carro_service.entidades.*;
@Service
public class  CarroService {
  @Autowired
  private CarroRepositorio carrorepository;

  public List<Carro> GetAllCarros(){
      return carrorepository.findAll();
  }

  public Carro GuardarCarro(Carro nuevo){
    return carrorepository.save(nuevo);
  }

  public Carro EncontrarCarro(int id){
      return carrorepository.findById(id).orElse(null);
  }
    public List<Carro> CarrosByUsuario(int usuarioID)
    {
      return carrorepository.findByusuarioId(usuarioID);
    }


}
