package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "service")
public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String serviceName;
    private double cost;

    @OneToMany(mappedBy = "service")
    private List<GuestServiceModel> guestServices;

    public ServiceModel(UUID id, String serviceName, double cost, List<GuestServiceModel> guestServices) {
        this.id = id;
        this.serviceName = serviceName;
        this.cost = cost;
        this.guestServices = guestServices;
    }
    public ServiceModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<GuestServiceModel> getGuestServices() {
        return guestServices;
    }

    public void setGuestServices(List<GuestServiceModel> guestServices) {
        this.guestServices = guestServices;
    }
}