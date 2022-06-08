package com.moto_service.moto_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto_service.moto_service.entidades.Moto;
import com.moto_service.moto_service.repositorio.MotoRepositorio;

@Service
public class MotoService {
   @Autowired
   private MotoRepositorio motorepositorio;

    public List<Moto> ListarMotos(){
        return motorepositorio.findAll();
    }
    public Moto BuscarMotoBYId(int id){
        return motorepositorio.findById(id).orElse(null);
    }
    public Moto GuardarMoto(Moto nueva){
        return motorepositorio.save(nueva);
    }
    public List<Moto> UsuarioMotos(int usuarioID){
        return motorepositorio.findByusuarioID(usuarioID);
    }

}
