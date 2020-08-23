package com.swaileh.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaileh.supermarket.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
}
