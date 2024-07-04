package com.javaspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.entities.ReviewEntity;
import com.javaspringboot.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	public void createReview(ReviewEntity review) {
		log.info("ReviewService ::: createReview {}", review.toString());
		reviewRepository.save(review);
		log.info("ReviewService ::: review saved successfully");
	}

	public List<ReviewEntity> getAllReviewsByProductId(Long productId) {
		log.info("ReviewService ::: getAllReviewByProductId {}", productId);
		return reviewRepository.findByProductId(productId);
	}
}
