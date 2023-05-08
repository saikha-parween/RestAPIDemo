package com.customer.controller;

import com.customer.dto.AddressDTO;
import com.customer.exception.ApplicationException;
import com.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping()
@Validated
public class AddressController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/address")
    public ResponseEntity<String> addAddress(@Valid @RequestBody AddressDTO addressDTO) throws ApplicationException {
        Integer Id = userService.addAddress(addressDTO);
        String successMessage = "INSERT_SUCCESS " + Id;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }


}
