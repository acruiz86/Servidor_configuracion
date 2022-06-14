package com.usuario_service.usuario_service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario_service.usuario_service.modelo.Carro;

import java.util.List;

@FeignClient(value = "carro-service", url = "http://localhost:8082/carro")
public interface CarroFeignClient {
    @GetMapping()
    List<Carro> ListarCarros();
    @PostMapping()
    Carro save(@RequestBody Carro nuevo);

}
