package com.example.carshop.demo.service;

import com.example.carshop.demo.car.CarResource;
import com.example.carshop.demo.domain.Carro;
import com.example.carshop.demo.exception.BusinessException;
import com.example.carshop.demo.repository.CarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class CarService {


    @Autowired
    private CarRepository repository;

    @Autowired
    private CarResource carResource;

    public void findCreditCardById() {
    }

  public Carro findById(Long id){
      return repository.findByIdAndDeletedIsFalse(id)
              .orElseThrow(() -> new BusinessException("Carro não encontrado"));
  }

    public Carro create(Carro entity){
        return repository.save(entity);
    }

    public Carro update(Carro entity){
        return repository.save(entity);
    }

    public void delete(Long id){
        Carro carro = findById(id);
        carro.setDeleted(true);
        repository.save(carro);
    }
}
