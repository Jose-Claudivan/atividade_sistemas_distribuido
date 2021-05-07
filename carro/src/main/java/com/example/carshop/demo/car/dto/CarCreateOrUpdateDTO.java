package com.example.carshop.demo.car.dto;

import com.example.carshop.demo.domain.Carro;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Optional;

@Data
public class CarCreateOrUpdateDTO {

    private Long id;

    @NotBlank(message = "Modelo não informado")
    //@Length(min = 0, max = 16, message = "Modelo invalido")
    private String model;

    @NotBlank(message = "Ano não informado")
    //@Length(min = 0, max = 16, message = "Ano invalido")
    private String year;

    @NotBlank(message = "Marca não informada")
    //@Length(min = 0, max = 16, message = "Marca invalida")
    private String brand;

    @NotBlank(message = "Cor não informada")
    //@Length(min = 0, max = 16, message = "Cor invalida")
    private String color;

    private Double value;

    public static Carro to(CarCreateOrUpdateDTO dto){
        if(Objects.isNull(dto)){
            return null;
        }

        Carro entity = new Carro();

        Optional.ofNullable(dto.getModel())
                .ifPresent(entity::setModel);

        Optional.ofNullable(dto.getYear())
                .ifPresent(entity::setYear);

        Optional.ofNullable(dto.getBrand())
                .ifPresent(entity::setBrand);

        Optional.ofNullable(dto.getColor())
                .ifPresent(entity::setColor);

        Optional.ofNullable(dto.getValue())
                .ifPresent(entity::setValue);

        return entity;
    }

}
