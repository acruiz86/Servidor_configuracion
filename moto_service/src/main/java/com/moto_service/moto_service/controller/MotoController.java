package com.moto_service.moto_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto_service.moto_service.entidades.Moto;
import com.moto_service.moto_service.service.MotoService;

@RequestMapping("/moto")
@RestController
public class MotoController {
    @Autowired
    private MotoService motoservice;
    @GetMapping
    public ResponseEntity<List<Moto>> GetAllMoto(){
        List<Moto> todas=motoservice.ListarMotos();
        if (todas.isEmpty()) {
            return ResponseEntity.noContent().build();            
        }
        return ResponseEntity.ok(todas);

    }
    @PostMapping
    public ResponseEntity<Moto> GuardarMoto(@RequestBody Moto nueva){
        Moto insertada= motoservice.GuardarMoto(nueva);
        return ResponseEntity.ok(insertada);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> EncontrarMoto(@PathVariable("id") int id)
    {
        Moto encontrada= motoservice.BuscarMotoBYId(id);
        if (encontrada==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrada);
    }
    @GetMapping("/usuario/{usuarioID}")
    public ResponseEntity<List<Moto>> UsuarioMotod(@PathVariable("usuarioID") int usuarioID)
    {
        List<Moto> encontrada= motoservice.UsuarioMotos(usuarioID);
        if (encontrada==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrada);
    }
    
}
