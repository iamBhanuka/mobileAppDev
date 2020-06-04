package com.example.onlinebankingapplication;

import java.io.Serializable;

public class Details implements Serializable {
    private String nic;
    private String accNumber;
    private String salute1;
    private String getSalute2;
    private String firstName;
    private String lastName;
    private int dobYear;
    private int dobMonth;
    private int dobDay;
    private String phoneNumber;
    private String email;
    private String address;

    public Details() {
    }

    public Details(String nic, String accNumber, String salute1, String getSalute2, String firstName, String lastName, int dobYear, int dobMonth, int dobDay, String phoneNumber, String email, String address) {
        this.nic = nic;
        this.accNumber = accNumber;
        this.salute1 = salute1;
        this.getSalute2 = getSalute2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dobYear = dobYear;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getSalute1() {
        return salute1;
    }

    public void setSalute1(String salute1) {
        this.salute1 = salute1;
    }

    public String getGetSalute2() {
        return getSalute2;
    }

    public void setGetSalute2(String getSalute2) {
        this.getSalute2 = getSalute2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
