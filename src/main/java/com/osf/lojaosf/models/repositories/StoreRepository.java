package com.osf.lojaosf.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.osf.lojaosf.models.entities.Store;

public interface StoreRepository extends PagingAndSortingRepository<Store, Integer> {

    public Iterable<Store> findByNameContainingIgnoreCase(String Stores);

    @Query("SELECT s from Store s where s.name like %:name%")
    public Iterable<Store> searchByNameStore(@Param("name") String name);

    @Query("SELECT s from Store s where s.name like %:name%")
    public Iterable<Store> searchByNameLike(@Param("name") String name);

}