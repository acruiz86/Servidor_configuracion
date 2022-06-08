package com.carro_service.carro_service.controller;

import java.util.List;

import com.carro_service.carro_service.entidades.Carro;
import com.carro_service.carro_service.service.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class  CarroController {
    @Autowired
    private CarroService carroservice;

    @GetMapping
    public ResponseEntity<List<Carro>> ListarCarros(){
        List<Carro> nuevo = carroservice.GetAllCarros();
        if(nuevo.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(nuevo);
    }
    
    @PostMapping
    public ResponseEntity<Carro> GuardarCarro(@RequestBody Carro carro)
    {
        Carro insertado=carroservice.GuardarCarro(carro);
        return ResponseEntity.ok(insertado);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> ObtenerCarroId(@PathVariable("id") int id)
    {
        Carro fined=carroservice.EncontrarCarro(id);
        if(fined==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fined);
    }
    @GetMapping("/usuario/{usuarioID}")
    public ResponseEntity<List<Carro>> CarrodByUsuarioId(@PathVariable("usuarioID") int usuarioId)
    {
        List<Carro> carros=carroservice.CarrosByUsuario(usuarioId);
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
     }
     return ResponseEntity.ok(carros);

    }
    
}
