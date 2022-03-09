package com.osf.lojaosf.models.repositories;


import com.osf.lojaosf.models.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    @Query("SELECT c from Customer c where c.firstName like %:firstName%")
    Iterable<Customer> searchByNameLike(@Param("firstName") String partName);

}