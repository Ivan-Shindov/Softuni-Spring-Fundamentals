package com.example.coffeshopapp.repository;

import com.example.coffeshopapp.model.entity.OrderEntity;
import com.example.coffeshopapp.model.view.OrderViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


    @Query("SELECT o FROM OrderEntity o ORDER BY o.price DESC")
    List<OrderEntity> getAllOrderByDesc();
}
