package com.swaileh.supermarket.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.swaileh.supermarket.models.Item;
import com.swaileh.supermarket.repositories.ItemRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getItems() {
		List<Item> items = null;
		try {
			items = itemRepository.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot get items!");
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Optional<Item>> getItem(@PathVariable Integer id){
		Optional<Item> item = null;
		try {
			item = itemRepository.findById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot get items!");
		}
		return new ResponseEntity<Optional<Item>>(item,HttpStatus.OK);
	}

	@PostMapping("/items")
	public ResponseEntity<Void> addItem(@RequestBody Item item) {
		try {
			itemRepository.save(item);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot add item!");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> editItem(@PathVariable Integer id, @RequestBody Item newItem) {
		Item oldItem = itemRepository.findById(id).get();
		oldItem.copy(newItem);
		try {
			itemRepository.save(oldItem);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot update item!");
		}
		return new ResponseEntity<Item>(oldItem, HttpStatus.OK);
	}
	
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
		try {
			itemRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot update item!");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
