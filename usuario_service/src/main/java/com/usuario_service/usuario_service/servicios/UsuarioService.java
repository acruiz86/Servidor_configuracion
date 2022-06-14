package com.usuario_service.usuario_service.servicios;
import com.usuario_service.usuario_service.repositorio.*;
import com.usuario_service.usuario_service.entidades.Usuario;
import com.usuario_service.usuario_service.feignclients.CarroFeignClient;
import com.usuario_service.usuario_service.feignclients.MotoFeignClient;
import com.usuario_service.usuario_service.modelo.Carro;
import com.usuario_service.usuario_service.modelo.Moto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class  UsuarioService {
    @Autowired
    private CarroFeignClient carrofeignclient;  

    @Autowired  
    private MotoFeignClient motofeingclient;
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepositorio usuariorepositorio;
    
    public List<Carro> getCarros(int usuarioid){
        List<Carro> carros= restTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioid, List.class);
        return carros;
    } 
   
    public List<Carro> FeignGetCarros(){
        List<Carro> finedcarros=carrofeignclient.ListarCarros();
        return finedcarros;

    }

  public Carro GuardarCarro(int usuarioID, Carro insertar){
              Carro nuevoSave=insertar;
              nuevoSave.setUsuarioId(usuarioID);
              int idsss=nuevoSave.getUsuarioId();
            System.out.println("Cadena ");
           
            Carro nuevo= carrofeignclient.save(nuevoSave);
            return nuevo;
    }
    public Moto  GuardarMoto(int usuarioID, Moto insertar){
        insertar.setUsuarioID(usuarioID);
        System.out.println("Cadena ");
        
        Moto nuevo= motofeingclient.save(insertar);
        return nuevo;
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
     public Map<String,Object> CarrosYMotosUsuario(int idusuario){
        Usuario encontrar=usuariorepositorio.findById(idusuario).orElse(null);
        Map<String,Object> resultados=new HashMap<>();
        if (encontrar!=null) {       
        List<Carro> carrosDeUsuario=this.getCarros(idusuario);
        List<Moto> motosDeUsuario=this.getMotos(idusuario);
        resultados.put("Carros", carrosDeUsuario);
        resultados.put("Motos", motosDeUsuario);
        return resultados;
        }
        resultados.put("no encontrado", "Usuario no existe");
        return resultados;
    


     }

    
}
