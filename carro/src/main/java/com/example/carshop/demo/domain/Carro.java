package com.example.carshop.demo.domain;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carro")
@DynamicUpdate
@Data

public class Carro extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String model;

    @Column(nullable = false, length = 4)
    private String year;

    @Column(nullable = false, length = 15)
    private String brand;

    @Column(nullable = false, length = 10)
    private String color;

    @Column(nullable = true, length = 20)
    private Double value;


}
