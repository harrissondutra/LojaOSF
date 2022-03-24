package com.osf.lojaosf.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.osf.lojaosf.models.entities.Category;

public interface CategoriesRepository extends PagingAndSortingRepository<Category, Integer> {

    @Query("SELECT c from Category c where c.name like %:name%")
    public Iterable<Category> searchByNameLike(@Param("name") String partName);
}