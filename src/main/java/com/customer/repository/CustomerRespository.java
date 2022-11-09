package com.customer.repository;


import com.customer.entity.Customertable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRespository extends JpaRepository<Customertable, Integer> {

}
