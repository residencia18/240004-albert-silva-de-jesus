package com.swprojects.tutorial_web_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.tutorial_web_services.entities.OrderItem;
import com.swprojects.tutorial_web_services.entities.pk.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}