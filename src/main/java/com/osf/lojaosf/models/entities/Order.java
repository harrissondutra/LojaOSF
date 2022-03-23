package com.osf.lojaosf.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @Enumerated
    private StatusOrder statusOrder = StatusOrder.Awaiting_Shipment;

    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippingDate;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Staff staff;


    public Order() {
        
    }

    public Order(Customer customer, Store store) {
       Integer stockStore = store.getStock().getId();
       if (stockStore == null) {
            throw new IllegalStateException("No Stock in Store");
       }
        this.customer = customer;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}