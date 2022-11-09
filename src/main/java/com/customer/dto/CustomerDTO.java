package com.customer.dto;

import com.customer.dto.AddressDTO;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class CustomerDTO {

	private Integer customerId;

	@Email(message = "")
	@NotNull(message = "")
	private String emailId;

	@NotNull(message = "")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "")
	private String name;

	@PastOrPresent(message = "")
	private LocalDate dateOfBirth;

	@NotNull
	@Valid
	private AddressDTO addressDTO;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", addressDTO=" + addressDTO + "]";
	}

}
