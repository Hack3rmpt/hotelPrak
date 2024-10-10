package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class GuestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;
    private String middleName;

    @Size(min = 6, message = "Номер телефона слишком короткий")
    @Pattern(regexp = "\\d+", message = "Номер телефона должен содержать только цифры")
    private String phoneNumber;

    @Nullable
    private String email;

    @Size(min = 6, message = "Номер паспорта слишком короткий")
    @Pattern(regexp = "\\d+", message = "Номер паспорта должен содержать только цифры")
    private String passportNumber;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "guest")
    private List<BookingModel> bookings;

    @OneToMany(mappedBy = "guest")
    private List<GuestServiceModel> guestServices;

    public GuestModel(UUID id, String firstName, String lastName, String middleName, String phoneNumber, String email, String passportNumber, LocalDate dateOfBirth, List<BookingModel> bookings, List<GuestServiceModel> guestServices) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
        this.bookings = bookings;
        this.guestServices = guestServices;
    }

    public GuestModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public @Size(min = 6, message = "Номер телефона слишком короткий") @Pattern(regexp = "\\d+", message = "Номер телефона должен содержать только цифры") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 6, message = "Номер телефона слишком короткий") @Pattern(regexp = "\\d+", message = "Номер телефона должен содержать только цифры") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @Size(min = 6, message = "Номер паспорта слишком короткий") @Pattern(regexp = "\\d+", message = "Номер паспорта должен содержать только цифры") String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(@Size(min = 6, message = "Номер паспорта слишком короткий") @Pattern(regexp = "\\d+", message = "Номер паспорта должен содержать только цифры") String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public List<GuestServiceModel> getGuestServices() {
        return guestServices;
    }

    public void setGuestServices(List<GuestServiceModel> guestServices) {
        this.guestServices = guestServices;
    }
}