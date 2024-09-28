package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {
    List<FeedbackModel> findByEvaluation(int evaluation);
}
