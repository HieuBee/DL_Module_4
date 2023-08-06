package com.example.casestudy_module4.repository;

import com.example.casestudy_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer.customer_name like :item OR customer.customer_phone like :item OR customer.customer_id_card",nativeQuery = true)
    Page<Customer> findAllPageable(Pageable pageable, @Param("item") String item);
}
