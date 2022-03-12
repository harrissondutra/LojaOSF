package com.osf.lojaosf.models.repositories;


import com.osf.lojaosf.models.entities.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface StaffRepository extends PagingAndSortingRepository<Staff, Integer> {

    @Query("SELECT s from Staff s where s.firstName like %:firstName%")
    Iterable<Staff> searchByNameLike(@Param("firstName") String partName);

}