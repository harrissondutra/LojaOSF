package com.osf.lojaosf.models.repositories;

import com.osf.lojaosf.models.entities.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockRepository extends PagingAndSortingRepository<Stock, Integer> {


}