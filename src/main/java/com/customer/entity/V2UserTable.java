//package com.customer.entity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "usertable")
//public class V2UserTable {
//
//    @Id
//    private Integer userId;
//    private String emailId;
//    private String firstName;
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    private LocalDate dateOfBirth;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private Address address;
//    private String lastName;
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((this.getUserId() == null) ? 0 : this.getUserId().hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        V2UserTable other = (V2UserTable) obj;
//        if (this.getUserId() == null) {
//            return other.getUserId() == null;
//        } else return this.getUserId().equals(other.getUserId());
//    }
//
//    @Override
//    public String toString() {
//        return "V2UserTable{" +
//                "userId=" + userId +
//                ", emailId='" + emailId + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", address=" + address +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
//}