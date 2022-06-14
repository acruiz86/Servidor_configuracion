package com.usuario_service.usuario_service.controller;

import java.util.List;
import java.util.Map;

import com.usuario_service.usuario_service.servicios.*;

import ch.qos.logback.core.encoder.EchoEncoder;

import com.usuario_service.usuario_service.entidades.Usuario;
import com.usuario_service.usuario_service.modelo.Carro;
import com.usuario_service.usuario_service.modelo.Moto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;

    @GetMapping
    public ResponseEntity<List<Usuario>> ListarUsuarios() {
        List<Usuario> listaNueva = usuarioservice.GetAll();
        if (listaNueva.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaNueva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> EncontrarUsuario(@PathVariable("id") int id) {
        Usuario fined = usuarioservice.UsuarioById(id);
        if (fined == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fined);
    }

    @PostMapping
    public ResponseEntity<Usuario> GuardarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioinsertado = usuarioservice.GuardarUsuario(usuario);
        return ResponseEntity.ok(usuarioinsertado);
    }

    @GetMapping("/carro/{usuarioid}")
    public ResponseEntity<List<Carro>> CarrosUsuario(@PathVariable("usuarioid") int usuarioid) {
        List<Carro> fined = usuarioservice.getCarros(usuarioid);
        if (fined.isEmpty() || fined==null ) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fined);
    }

    @GetMapping("/moto/{usuarioid}")
    public ResponseEntity<List<Moto>> MotosUsuario(@PathVariable("usuarioid") int id) {
        List<Moto> fined = usuarioservice.getMotos(id);
        if (fined.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fined);
    }
    
    @PostMapping("/carro/{usuarioID}")
    public ResponseEntity<Carro> GuardarCarroContrll(@PathVariable("usuarioID") int usuarioID, @RequestBody Carro carro){
        Carro saved=usuarioservice.GuardarCarro(usuarioID, carro);
        return ResponseEntity.ok(saved);

    }
    @GetMapping("/carro/listar")
   public ResponseEntity<List<Carro>> TodosCarrosfeng(){
    List<Carro> carrossss=usuarioservice.FeignGetCarros();
    if (carrossss.isEmpty()) {
        return ResponseEntity.noContent().build();
        
    }
    return ResponseEntity.ok(carrossss);
   }
   @GetMapping("/todos/{usuarioID}")
   public ResponseEntity<Map<String,Object>> TodosLosVehiculos(@PathVariable("usuarioID") int usuarioID){
    Map<String,Object> res= usuarioservice.TodosLosVehiculos(usuarioID);
    return ResponseEntity.ok(res);

   }
}
