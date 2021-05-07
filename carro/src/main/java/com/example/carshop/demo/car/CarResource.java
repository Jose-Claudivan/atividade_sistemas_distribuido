package com.example.carshop.demo.car;

import com.example.carshop.demo.domain.Carro;
import com.example.carshop.demo.car.dto.CarCreateOrUpdateDTO;
import com.example.carshop.demo.car.dto.CarDTO;
import com.example.carshop.demo.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/carro")
@AllArgsConstructor
public class CarResource {

    @Autowired
    private final CarService service;

    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        JsonNode limit_card;
        Double car_value;
        car_value = service.findById(id).getValue();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/creditCard/2", String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode genericJson = mapper.readTree(responseEntity.getBody());
            limit_card = genericJson.get("limit");
            System.out.println("\n>> LIMITE DO CARTAO <<>> \n" + limit_card);
            System.out.println(">> VALOR CARRO <<>> \n" + car_value);

            if(car_value < limit_card.doubleValue()) {
                System.out.println("\n\n>> DÁ PARA COMPRAR! <<\n");
            } else {
                System.out.println("\n\n>> ULTRAPASSOU O LIMITE, SOLICITE UM AUMENTO! <<\n");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(service.findById(id));

    }


    @PostMapping
    public ResponseEntity<CarDTO> create(@Valid @RequestBody CarCreateOrUpdateDTO dto){
        CarDTO CarDTO = Optional.of(dto)
                .map(CarCreateOrUpdateDTO::to)
                .map(service::create)
                .map(com.example.carshop.demo.car.dto.CarDTO::from).get();
        return ResponseEntity.ok().body(CarDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CarDTO> update(
            @Valid @RequestBody CarCreateOrUpdateDTO dto,
            @PathVariable Long id){
        dto.setId(id);
        CarDTO carDTO = Optional.of(dto)
                .map(CarCreateOrUpdateDTO::to)
                .map(service::update)
                .map(CarDTO::from).get();
        return ResponseEntity.ok().body(carDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CarDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
