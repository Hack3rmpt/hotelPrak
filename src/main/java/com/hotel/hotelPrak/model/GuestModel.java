package com.hotel.hotelPrak.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class GuestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "\\d+", message = "Серия паспорта должна содержать только цифры")
    private String passportNumber;
    @Size(min = 6, message = "Номер телефона слишком короткий")
    private String phoneNumber;
    @Nullable
    private String email;
    private boolean isDeleted;

    public GuestModel(Long id, String firstName, String lastName, String passportNumber, String phoneNumber, @Nullable String email, boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isDeleted = isDeleted;
    }

    public GuestModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public @Size(min = 5, message = "Серия паспорта слишком короткая") String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(@Size(min = 5, message = "Серия паспорта слишком короткая") String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public @Size(min = 6, message = "Номер телефона слишком короткий") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 6, message = "Номер телефона слишком короткий") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

//    public boolean isDeleted() { return isDeleted; }
//    public void setDeleted(boolean deleted) { isDeleted = deleted; }
}