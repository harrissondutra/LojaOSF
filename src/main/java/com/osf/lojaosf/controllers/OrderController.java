package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Order;
import com.osf.lojaosf.models.entities.StatusOrder;
import com.osf.lojaosf.models.entities.Stock;
import com.osf.lojaosf.models.repositories.OrderRepository;
import com.osf.lojaosf.models.repositories.StockRepository;
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

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Order> getOrdersPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 5);
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

    @PostMapping("/changeStatus")
    public @ResponseBody
    Stock ChangeStatusOrder(@Valid int id, Order order) {

            switch (id) {
                case 1:
                    order.setStatusOrder(StatusOrder.Awaiting_Shipment);
                case 2:
                    order.setStatusOrder(StatusOrder.In_Transit);
                case 3:
                    order.setStatusOrder(StatusOrder.Delivered);
                case 4:
                    order.setStatusOrder(StatusOrder.Canceled);
                    return order.getStore().getStocks();
            }

           return Stock.checkProductStock().getStock();
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
