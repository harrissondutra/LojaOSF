package com.osf.lojaosf.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.osf.lojaosf.models.entities.Products;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Integer> {

	public Iterable<Products> findByNameContainingIgnoreCase(String products);
	
    @Query("SELECT p from Products p where p.name like %:name%")
    Iterable<Products> searchByNameLike(@Param("name") String partName);



}