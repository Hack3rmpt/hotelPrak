package com.hotel.hotelPrak.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class FeedbackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String guest;
    private int evaluation;
    @Size(min = 3, message = "Слишком короткий комментарий, в нем не смысла")
    private String comment;
    @Nullable
    private String picture;


    public FeedbackModel(int id, String guest, int evaluation, String comment, String picture) {
        this.id = id;
        this.guest = guest;
        this.evaluation = evaluation;
        this.comment = comment;
        this.picture = picture;
    }

    public FeedbackModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public @Size(min = 3, message = "Слишком короткий комментарий, в нем не смысла") String getComment() {
        return comment;
    }

    public void setComment(@Size(min = 3, message = "Слишком короткий комментарий, в нем не смысла") String comment) {
        this.comment = comment;
    }

    @Nullable
    public String getPicture() {
        return picture;
    }

    public void setPicture(@Nullable String picture) {
        this.picture = picture;
    }

    // Геттеры и сеттеры
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getGuest() {
//        return guest;
//    }
//
//    public void setGuest(String guest) {
//        this.guest = guest;
//    }
//
//    public int getEvaluation() {
//        return evaluation;
//    }
//
//    public void setEvaluation(int evaluation) {
//        this.evaluation = evaluation;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
}

