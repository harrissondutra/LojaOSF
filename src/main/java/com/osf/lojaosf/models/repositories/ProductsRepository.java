package com.osf.lojaosf.models.repositories;


import com.osf.lojaosf.models.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends PagingAndSortingRepository<Product, Integer> {

	public Iterable<Product> findByNameContainingIgnoreCase(String products);
	
    @Query("SELECT p from Product p where p.name like %:name%")
    List<Product> searchByNameLike(@Param("name") String partName);



}