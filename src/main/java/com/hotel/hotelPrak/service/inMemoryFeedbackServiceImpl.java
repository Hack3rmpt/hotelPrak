package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.repository.FeedbackRepository;
import com.hotel.hotelPrak.repository.inMemoryFeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class inMemoryFeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository feedbackRepository;

    public inMemoryFeedbackServiceImpl(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }


    @Override
    public List<FeedbackModel> findAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedbackModel findFeedbackById(long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public FeedbackModel addFeedback(FeedbackModel Feedback) {
        return feedbackRepository.save(Feedback);
    }

    @Override
    public FeedbackModel updateFeedback(FeedbackModel Feedback) {
        if(feedbackRepository.existsById(Feedback.getId())){
            return feedbackRepository.save(Feedback);
        }
        return null;
    }

    @Override
    public void deleteFeedback(long id) {
        if (feedbackRepository.existsById(id)){
            feedbackRepository.deleteById(id);
        }
    }
    @Override
    public List<FeedbackModel> findFeedbackByEvaluation(int evaluation) {
        return feedbackRepository.findByEvaluation(evaluation);
    }


//    @Override
//    public List<FeedbackModel> findFeedbackByEvaluation(int evaluation) {
//        return feedbackRepository.findAllFeedback().stream()
//                .filter(feedback -> feedback.getEvaluation() == evaluation)
//                .collect(Collectors.toList());
//    }
}
