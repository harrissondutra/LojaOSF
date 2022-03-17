package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Order;
import com.osf.lojaosf.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Order> getOrdersPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return orderRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrdersById(@PathVariable int id) {
        return orderRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Order saveOrders(@Valid Order order) {
        orderRepository.save(order);
        return order;
    }

    @PutMapping
    public Order changeOrders(@Valid Order order){
        orderRepository.save(order);
        return order;
    }

    @DeleteMapping("/{id}")
    public void deleteOrdersById(@PathVariable int id) {
        orderRepository.deleteById(id);
    }
}
