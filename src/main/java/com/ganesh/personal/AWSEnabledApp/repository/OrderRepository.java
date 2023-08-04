package com.ganesh.personal.AWSEnabledApp.repository;

import com.ganesh.personal.AWSEnabledApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreatedBy(String createdBy);

    List<Order> findByCreatedOn(String createdOn);
}
