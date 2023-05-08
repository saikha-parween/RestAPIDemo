package com.customer.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class UserDTO {

    private Integer userId;

    @Email(message = "Should be in email format")
    @NotNull(message = "Email should not be null")
    private String emailId;

    @NotNull(message = "Name should not be null")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should be alphabets only")
    private String name;

    @PastOrPresent(message = "Date should not be of future")
    private LocalDate dateOfBirth;

    @NotNull
    @Valid
    private AddressDTO addressDTO;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "CustomerDTO [customerId=" + userId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
                + dateOfBirth + ", addressDTO=" + addressDTO + "]";
    }

}
