package com.example.carshop.demo.car.dto;

import com.example.carshop.demo.domain.Carro;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Data
public class CarDTO implements Serializable {

    private String model;
    private String year;
    private Double value;

    public static CarDTO from(Carro entity){
        if(Objects.isNull(entity)){
            return null;
        }
        CarDTO dto = new CarDTO();

        Optional.ofNullable(entity.getModel())
                .ifPresent(dto::setModel);

        Optional.ofNullable(entity.getYear())
                .ifPresent(dto::setYear);

        Optional.ofNullable(entity.getValue())
                .ifPresent(dto::setValue);

        return dto;
    }
}
