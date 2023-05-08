package com.customer.repository;


import com.customer.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRespository extends JpaRepository<UserTable, Integer> {

}
