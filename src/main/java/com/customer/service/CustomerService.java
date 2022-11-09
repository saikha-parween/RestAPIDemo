package com.customer.service;

import java.util.List;

import com.customer.dto.AddressDTO;
import com.customer.dto.CustomerDTO;
import com.customer.exception.BankException;



public interface CustomerService {
	public Integer addCustomer(CustomerDTO customerDTO) throws BankException;
	public CustomerDTO getCustomer(Integer customerId) throws BankException;
	public void updateCustomer(Integer customerId, String emailId)throws BankException;
	public void deleteCustomer(Integer customerId)throws BankException;
	public List<CustomerDTO> getAllCustomers() throws BankException;

	public Integer addAddress(AddressDTO addressDTO);
}
