package com.osf.lojaosf.models.repositories;


import com.osf.lojaosf.models.entities.Brands;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface BrandsRepository extends PagingAndSortingRepository<Brands, Integer> {

    public Iterable<Brands> findByNameContainingIgnoreCase(String brands);

    @Query("SELECT b from Brands b where b.name like %:name%")
    public Iterable<Brands> searchByNameLike(@Param("name") String partName);

}