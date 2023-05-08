package com.customer.service;

import com.customer.dto.AddressDTO;
import com.customer.dto.UserDTO;
import com.customer.exception.ApplicationException;

import java.util.List;


public interface UserService {
    Integer addUser(UserDTO userDTO) throws ApplicationException;

    UserDTO getUser(Integer userId) throws ApplicationException;

    void updateUser(Integer userId, String emailId) throws ApplicationException;

    void deleteUser(Integer userId) throws ApplicationException;

    List<UserDTO> getAllUsers() throws ApplicationException;

    Integer addAddress(AddressDTO addressDTO);

//    Integer addV2User(V2UserDTO customer);
}
