package com.cg.pizza.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.beans.PizzaOrders;

public interface OrderDAO extends JpaRepository<PizzaOrders, Integer>
{
}
