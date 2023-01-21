package com.onlinebusadda.repository;

import com.onlinebusadda.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
}
