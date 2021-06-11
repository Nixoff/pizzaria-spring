package com.nixoff.pizzaria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nixoff.pizzaria.models.Pizza;
import com.nixoff.pizzaria.repository.PizzaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pizzas")
@CrossOrigin(origins="*")
public class PizzaResource {

	@Autowired
	PizzaRepository pizzaRepository;
	
	@GetMapping("/pizzas")
	@ApiOperation(value="Retorna uma lista de pizzas")
	public List<Pizza> listaPizza(){
		return pizzaRepository.findAll();
	}
	
	
	@GetMapping("/pizza/{id}")
	@ApiOperation(value="Retorna uma unica pizza")
	public Pizza listaPizzaUnica(@PathVariable(value="id") long id) {
		return pizzaRepository.findById(id);
	}
	
	@PostMapping("pizza")
	@ApiOperation(value="Salva uma pizza")
	public Pizza salvaPizza(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
	
	@DeleteMapping("/pizza")
	@ApiOperation(value="Deleta uma pizza")
	public void deletaPizza(@RequestBody Pizza pizza) {
		pizzaRepository.delete(pizza);
	}
	
	@PutMapping("/pizza")
	@ApiOperation(value="Atualiza uma pizza")
	public Pizza atualizaPizza(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
}
