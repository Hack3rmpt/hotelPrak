package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.model.GuestModel;

import java.util.List;

public interface FeedbackService {
    public List<FeedbackModel> findAllFeedback();

    public FeedbackModel findFeedbackById(long id);

    public FeedbackModel addFeedback(FeedbackModel Feedback);

    public FeedbackModel updateFeedback(FeedbackModel Feedback);

    public  void deleteFeedback(long id);

    List<FeedbackModel> findFeedbackByEvaluation(int evaluation);
}