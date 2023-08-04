package com.ganesh.personal.AWSEnabledApp.controller;

import com.ganesh.personal.AWSEnabledApp.exception.ResourceNotFoundException;
import com.ganesh.personal.AWSEnabledApp.model.Order;
import com.ganesh.personal.AWSEnabledApp.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/order")
@Transactional
@Log4j2
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllTutorials() {


        List<Order> orders = new ArrayList<Order>(orderRepository.findAll());

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        Order order1 = orderRepository.save(order);
//        log.info("Created order: "+order);
//        log.info("Stored order:" + order1);

        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Order with id="+id));

//        log.info("Found Order: "+ order);
//        if (!order.getOrderItems().isEmpty())
//        {
//            log.info("Found Order Items with first order Item:"+order.getOrderItems().stream().findFirst());
//        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
