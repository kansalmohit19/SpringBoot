package com.javaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.entities.ReviewEntity;
import com.javaspringboot.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@PostMapping
	public void createReview(@RequestBody ReviewEntity review) {
		log.info("ReviewController ::: createReview {}", review.toString());
		reviewService.createReview(review);
	}

	@GetMapping("{productId}")
	public List<ReviewEntity> getAllReviews(@PathVariable Long productId) {
		log.info("ReviewController ::: getAllReviews {}", productId);
		return reviewService.getAllReviewsByProductId(productId);
	}

}
