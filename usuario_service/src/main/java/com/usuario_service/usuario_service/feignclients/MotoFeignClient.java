package com.usuario_service.usuario_service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario_service.usuario_service.modelo.Moto;

import java.util.List;

@FeignClient(name = "moto-service",url = "http://localhost:8083/moto")
public interface MotoFeignClient {
    @PostMapping()
     Moto save(@RequestBody Moto nuevo);
    @GetMapping()
     List<Moto> motosGetFeign();

    
}
