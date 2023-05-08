package com.customer.service;

import com.customer.dto.AddressDTO;
import com.customer.dto.UserDTO;
import com.customer.entity.Address;
import com.customer.entity.UserTable;
import com.customer.exception.ApplicationException;
import com.customer.repository.AddressRepository;
import com.customer.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "customerService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public UserDTO getUser(Integer customerId) throws ApplicationException {
        Optional<UserTable> optional = userRespository.findById(customerId);
        UserTable user = optional.orElseThrow(() -> new ApplicationException("Service.CUSTOMER_NOT_FOUND"));
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setName(user.getName());
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(user.getAddress().getAddressId());
        addressDTO.setStreet(user.getAddress().getStreet());
        addressDTO.setCity(user.getAddress().getCity());
        userDTO.setAddressDTO(addressDTO);
        return userDTO;
    }

    @Override
    public Integer addUser(UserDTO userDTO) throws ApplicationException {
        UserTable user = new UserTable();
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setEmailId(userDTO.getEmailId());
        user.setName(userDTO.getName());
        user.setUserId(userDTO.getUserId());
        Address address = new Address();
        address.setAddressId(userDTO.getAddressDTO().getAddressId());
        address.setStreet(userDTO.getAddressDTO().getStreet());
        address.setCity(userDTO.getAddressDTO().getCity());
        user.setAddress(address);
        userRespository.save(user);
        return user.getUserId();
    }

//    @Override
//    public Integer addV2User(V2UserDTO userDTO) {
//        UserTable customer = new UserTable();
//        customer.setDateOfBirth(userDTO.getDateOfBirth());
//        customer.setEmailId(userDTO.getEmailId());
//        customer.setFirstName(userDTO.getFirstName());
//        customer.setLastName(userDTO.getLastName());
//        customer.setUserId(userDTO.getUserId());
//        Address address = new Address();
//        address.setAddressId(userDTO.getAddressDTO().getAddressId());
//        address.setStreet(userDTO.getAddressDTO().getStreet());
//        address.setCity(userDTO.getAddressDTO().getCity());
//        customer.setAddress(address);
//
//        userRespository.save(customer);
//        return customer.getUserId();
//    }


    @Override
    public void updateUser(Integer customerId, String emailId) throws ApplicationException {
        Optional<UserTable> customer = userRespository.findById(customerId);
        UserTable c = customer.orElseThrow(() -> new ApplicationException("Service.CUSTOMER_NOT_FOUND"));
        c.setEmailId(emailId);
    }

    @Override
    public void deleteUser(Integer customerId) throws ApplicationException {
        Optional<UserTable> customer = userRespository.findById(customerId);
        customer.orElseThrow(() -> new ApplicationException("Service.CUSTOMER_NOT_FOUND"));
        userRespository.deleteById(customerId);
    }

    @Override
    public List<UserDTO> getAllUsers() throws ApplicationException {
        Iterable<UserTable> customers = userRespository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        customers.forEach(customer -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(customer.getUserId());
            userDTO.setDateOfBirth(customer.getDateOfBirth());
            userDTO.setEmailId(customer.getEmailId());
            userDTO.setName(customer.getName());

            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setAddressId(customer.getAddress().getAddressId());
            addressDTO.setStreet(customer.getAddress().getStreet());
            addressDTO.setCity(customer.getAddress().getCity());
            userDTO.setAddressDTO(addressDTO);
            userDTOS.add(userDTO);
        });
        if (userDTOS.isEmpty())
            throw new ApplicationException("Service.CUSTOMERS_NOT_FOUND");
        return userDTOS;
    }

    @Override
    public Integer addAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setAddressId(addressDTO.getAddressId());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        addressRepository.save(address);
        System.out.println("cgffffg");
        return address.getAddressId();

    }

}
