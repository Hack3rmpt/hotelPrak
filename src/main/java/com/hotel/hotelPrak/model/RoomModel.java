package com.hotel.hotelPrak.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TypeRoom;
    private String DescriptionRoom;
//    @Nullable возможность сделать поле нулевым


    public RoomModel(Long id, String typeRoom, String descriptionRoom) {
        this.id = id;
        TypeRoom = typeRoom;
        DescriptionRoom = descriptionRoom;
    }

    public RoomModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeRoom() {
        return TypeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        TypeRoom = typeRoom;
    }

    public String getDescriptionRoom() {
        return DescriptionRoom;
    }

    public void setDescriptionRoom(String descriptionRoom) {
        DescriptionRoom = descriptionRoom;
    }

    //    public int getId() {
//        return id;
//    }
//
//    public String getTypeRoom() {
//        return TypeRoom;
//    }
//
//    public String getDescriptionRoom() {
//        return DescriptionRoom;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setTypeRoom(String typeRoom) {
//        TypeRoom = typeRoom;
//    }
//
//    public void setDescriptionRoom(String descriptionRoom) {
//        DescriptionRoom = descriptionRoom;
//    }


}



//public class User{

//    private int id;
//    private String Name;
//    private String LastName;
//
//
//}
