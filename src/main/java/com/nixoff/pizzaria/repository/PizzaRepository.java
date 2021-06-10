package com.nixoff.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nixoff.pizzaria.models.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
	Pizza findById(long id);

}
