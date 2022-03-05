package com.osf.lojaosf.models.repositories;


import com.osf.lojaosf.models.entities.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface BrandsRepository extends PagingAndSortingRepository<Brand, Integer> {

    public Iterable<Brand> findByNameContainingIgnoreCase(String brands);

    @Query("SELECT b from Brand b where b.name like %:name%")
    public Iterable<Brand> searchByNameLike(@Param("name") String partName);

}