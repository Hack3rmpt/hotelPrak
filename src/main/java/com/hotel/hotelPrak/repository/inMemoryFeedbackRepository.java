package com.hotel.hotelPrak.repository;


import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.model.GuestModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class inMemoryFeedbackRepository {
//    private List<FeedbackModel> Feedback = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//
//
//    public List<FeedbackModel> findAllFeedback(){
//        return new ArrayList<>(Feedback);
//    }
//    public FeedbackModel addFeedback(FeedbackModel feedback){
//        feedback.setId(idCounter.getAndIncrement());
//        Feedback.add(feedback);
//        return feedback;
//    }
//    public FeedbackModel updateFeedback(FeedbackModel feedback){
//        for (int i = 0; i < Feedback.size(); i++){
//            if(Feedback.get(i). getId() == feedback.getId()){
//                Feedback.set(i, feedback);
//                return feedback;
//            }
//        }
//        return null;
//    }
//    public void deleteFeedback(int id){
//        Feedback.removeIf(feedback -> feedback.getId() == id);
//    }
//    public  FeedbackModel findFeedbackById(int id){
//        return Feedback.stream().filter(feedback -> feedback.getId() == id). findFirst().orElse(null);
//    }
}
