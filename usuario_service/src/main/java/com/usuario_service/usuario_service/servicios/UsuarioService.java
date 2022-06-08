package com.usuario_service.usuario_service.servicios;
import com.usuario_service.usuario_service.repositorio.*;
import com.usuario_service.usuario_service.entidades.Usuario;
import com.usuario_service.usuario_service.modelo.Carro;
import com.usuario_service.usuario_service.modelo.Moto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class  UsuarioService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepositorio usuariorepositorio;
    
    public List<Carro> getCarros(int usuarioid){
        List<Carro> carros= restTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioid, List.class);
        return carros;
    } 
    public List<Moto> getMotos(int usuarioid){
        List<Moto> motos= restTemplate.getForObject("http://localhost:8083/moto/usuario/"+usuarioid, List.class);
        return motos;
    }     
    public List<Usuario> GetAll(){
        return usuariorepositorio.findAll();
    }
     public Usuario UsuarioById(int id)
     {
        return usuariorepositorio.findById(id).orElse(null);
     }
     public Usuario GuardarUsuario(Usuario nuevo)
     {
          Usuario nuevousuario= usuariorepositorio.save(nuevo);
          return nuevousuario;

     }

    
}
