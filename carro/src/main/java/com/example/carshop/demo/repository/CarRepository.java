package com.example.carshop.demo.repository;


import com.example.carshop.demo.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface CarRepository extends JpaRepository<Carro, Long> {

    public Optional<Carro> findByIdAndDeletedIsFalse(Long id);

    public Optional<Carro> findById(Long id);




}
