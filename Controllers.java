package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	
	@GetMapping("/product")
	public Product greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Product product = new Product("casa", 222);
		return product;
	}
	
	@GetMapping("/products")
	public List<Product> listaPersonas() {
		List<Product> lista = new ArrayList<Product>();
		Product p = new Product("chuches", 222);
		lista.add(p);
		Product p2 = new Product("caramelo", 222);
		lista.add(p2);
		return lista;
	}
	
	@GetMapping("/show")
	public Product giveValues(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value="precio", defaultValue = "0") int precio) { 
		Product product = new Product(name, precio);
		return product;
	}
	
	
	// http://localhost:8081/convertir/<moneda_origen>/to/<moneda_destino>?cuantia=22
	// http://localhost:8081/convertir/euro/to/dolar?cuantia=22
	@GetMapping("convertir/{moneda_origen}/to/{moneda_destino}")
	public String getUser(@PathVariable String moneda_origen, @PathVariable String moneda_destino, @RequestParam(value = "cuantia", defaultValue = "0") int cuantia) {
		
		return "Convertir, moneda origen: " + moneda_origen + ", moneda destino: " + moneda_destino+ ", cuantia: "+cuantia;
	
		//return userId;
	}

	
	// http://localhost:8081/users/<userId>/messages/<messageId>
	@GetMapping(path = "users/{userId}/messages/{messageId}")
	public String getUser(@PathVariable String userId, @PathVariable String messageId)
	{
	 return "get user was called with path userId variable " + userId + " and message id " + messageId;
	}
	
	

}
