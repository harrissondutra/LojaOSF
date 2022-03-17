package com.osf.lojaosf.models.repositories;

import com.osf.lojaosf.models.entities.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
}