package com.nixoff.pizzaria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nixoff.pizzaria.models.Pizza;
import com.nixoff.pizzaria.repository.PizzaRepository;

@RestController
@RequestMapping(value="/api")
public class PizzaResource {

	@Autowired
	PizzaRepository pizzaRepository;
	
	@GetMapping("/pizzas")
	public List<Pizza> listaPizza(){
		return pizzaRepository.findAll();
	}
	
	
	@GetMapping("/pizza/{id}")
	public Pizza listaPizzaUnica(@PathVariable(value="id") long id) {
		return pizzaRepository.findById(id);
	}
	
	@PostMapping("pizza")
	public Pizza salvaPizza(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
}
