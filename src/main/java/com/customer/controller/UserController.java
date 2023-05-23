package com.customer.controller;

import com.customer.dto.UserDTO;
import com.customer.exception.ApplicationException;
import com.customer.service.UserService;
import com.customer.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<Object> addCustomer(@Valid @RequestBody UserDTO customer) throws ApplicationException {
        Integer customerId = userService.addUser(customer);
        String successMessage = "INSERT_SUCCESS with customerId  " + customerId;
        return ResponseHandler.generateResponse(successMessage, HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> getAllCustomers() throws ApplicationException {
        List<UserDTO> customerList = userService.getAllUsers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<UserDTO> getCustomerDetails(@PathVariable @Min(value = 1, message = "{user userId invalid}") @Max(value = 100, message = "{user userId invalid}") Integer userId) throws ApplicationException {
        UserDTO customer = userService.getUser(userId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Integer userId, @Valid @RequestBody UserDTO customer)
            throws ApplicationException {
        userService.updateUser(userId, customer.getEmailId());
        String successMessage = "UPDATE_SUCCESS";
        return ResponseHandler.generateResponse(successMessage, HttpStatus.OK);
    }


    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer userId) throws ApplicationException {
        userService.deleteUser(userId);
        String successMessage = "DELETE_SUCCESS";
        return ResponseHandler.generateResponse(successMessage, HttpStatus.OK);
    }
    //versioning example
//    @PostMapping(value = "/v1/users")
//    public ResponseEntity<String> addUser(@Valid @RequestBody V2UserDTO customer) throws ApplicationException {
//        Integer customerId = userService.addV2User(customer);
//        String successMessage = "INSERT_SUCCESS" + customerId;
//        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
//    }
}
