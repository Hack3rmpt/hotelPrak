package com.hotel.hotelPrak.model;


public enum RoleEnum implements GrantedAuthority{
    USSER, ADMIN;


    @Override
    public String getAuthority(){
        return name();
    }
}
