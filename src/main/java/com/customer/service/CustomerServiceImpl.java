package com.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.customer.dto.AddressDTO;
import com.customer.entity.Address;
import com.customer.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dto.CustomerDTO;
import com.customer.entity.Customertable;
import com.customer.exception.BankException;
import com.customer.repository.CustomerRespository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRespository customerRespository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws BankException {
		Optional<Customertable> optional = customerRespository.findById(customerId);
		Customertable customer = optional.orElseThrow(() -> new BankException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(customer.getAddress().getAddressId());
		addressDTO.setStreet(customer.getAddress().getStreet());
		addressDTO.setCity(customer.getAddress().getCity());
		customerDTO.setAddressDTO(addressDTO);
		return customerDTO;
	}

	@Override
	public Integer addCustomer(CustomerDTO customerDTO) throws BankException {
		Customertable customer = new Customertable();
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());
		customer.setCustomerId(customerDTO.getCustomerId());
		Address address = new Address();
		address.setAddressId(customerDTO.getAddressDTO().getAddressId());
		address.setStreet(customerDTO.getAddressDTO().getStreet());
		address.setCity(customerDTO.getAddressDTO().getCity());
		System.out.println(address);
		customer.setAddress(address);
		System.out.println(customer);
		System.out.println(customer.getCustomerId());

		customerRespository.save(customer);
		System.out.println("vcgfhggf");
		return customer.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws BankException {
		Optional<Customertable> customer = customerRespository.findById(customerId);
		Customertable c = customer.orElseThrow(() -> new BankException("Service.CUSTOMER_NOT_FOUND"));
		c.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws BankException {
		Optional<Customertable> customer = customerRespository.findById(customerId);
		customer.orElseThrow(() -> new BankException("Service.CUSTOMER_NOT_FOUND"));
		customerRespository.deleteById(customerId);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws BankException {
		Iterable<Customertable> customers = customerRespository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());

			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAddressId(customer.getAddress().getAddressId());
			addressDTO.setStreet(customer.getAddress().getStreet());
			addressDTO.setCity(customer.getAddress().getCity());
			customerDTO.setAddressDTO(addressDTO);
			customerDTOs.add(customerDTO);
		});
		if (customerDTOs.isEmpty())
			throw new BankException("Service.CUSTOMERS_NOT_FOUND");
		return customerDTOs;
	}
	@Override
	public Integer addAddress(AddressDTO addressDTO){
		Address address=new Address();
		address.setAddressId(addressDTO.getAddressId());
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		addressRepository.save(address);
		System.out.println("cgffffg");
		return address.getAddressId();

	}

}
