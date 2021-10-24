package com.example.battleshipsexam.repository;

import com.example.battleshipsexam.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {

    @Query("SELECT s FROM ShipEntity s where s.user.username = :username")
    Set<ShipEntity> findAllForCurrentUser(String username);

    @Query("SELECT s FROM ShipEntity s where s.user.username <> :username")
    Set<ShipEntity> findAllForOtherUser(String username);

    ShipEntity findByName(String attacker);

    @Query("SELECT s FROM ShipEntity s ORDER BY s.health")
    Set<ShipEntity> findAllOrderedByHealth();
}
