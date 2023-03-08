package com.springdemo.library.service;

import com.springdemo.library.model.Review;
import com.springdemo.library.repository.ReviewRepository;
import com.springdemo.library.requestmodels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class ReviewService {

  private final ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
    Review validateReview = reviewRepository
        .findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());

    if (validateReview != null) {
      throw new Exception("Review already created");
    }

    Review review = new Review();
    review.setBookId(reviewRequest.getBookId());
    review.setRating(reviewRequest.getRating());
    review.setUserEmail(userEmail);

    if (reviewRequest.getReviewDescription().isPresent()) {
      review.setReviewDescription(
          reviewRequest.getReviewDescription().map(Objects::toString).orElse(null)
      );
    }

    review.setDate(Date.valueOf(LocalDate.now()));

    reviewRepository.save(review);
  }

  // check if the user already left the review
  public boolean userReviewListed(String userEmail, Long bookId) {
    Review validateReview = reviewRepository
        .findByUserEmailAndBookId(userEmail, bookId);

    return validateReview != null;
  }
}
