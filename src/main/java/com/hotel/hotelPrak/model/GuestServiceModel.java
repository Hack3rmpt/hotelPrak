package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "guest_service")
public class GuestServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate serviceDate;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestModel guest;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceModel service;

    public GuestServiceModel(UUID id, LocalDate serviceDate, GuestModel guest, ServiceModel service) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.guest = guest;
        this.service = service;
    }

    public GuestServiceModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public GuestModel getGuest() {
        return guest;
    }

    public void setGuest(GuestModel guest) {
        this.guest = guest;
    }

    public ServiceModel getService() {
        return service;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }
}