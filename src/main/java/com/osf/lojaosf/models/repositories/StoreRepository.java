package com.osf.lojaosf.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.osf.lojaosf.models.entities.Stores;

public interface StoreRepository extends PagingAndSortingRepository<Stores, Integer> {

    public Iterable<Stores> findByNameContainingIgnoreCase(String Stores);

    @Query("SELECT s from Stores s where s.name like %:name%")
    public Iterable<Stores> searchByNameStore(@Param("name") String name);

    @Query("SELECT s from Stores s where s.name like %:name%")
    public Iterable<Stores> searchByNameLike(@Param("name") String name);

}