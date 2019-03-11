package com.cg.pizza.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.beans.Items;

public interface ItemDAO extends JpaRepository<Items, Integer>{
	
}
