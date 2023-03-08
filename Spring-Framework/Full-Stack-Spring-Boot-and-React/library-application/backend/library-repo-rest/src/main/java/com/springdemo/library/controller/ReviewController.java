package com.springdemo.library.controller;

import com.springdemo.library.requestmodels.ReviewRequest;
import com.springdemo.library.service.ReviewService;
import com.springdemo.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

  private final ReviewService reviewService;
  private final String sub = "\"sub\"";

  @Autowired
  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping("/secure")
  public void postReview(@RequestHeader(value = "Authorization") String token,
                         @RequestBody ReviewRequest reviewRequest) throws  Exception {

    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    if (userEmail == null) {
      throw new Exception("User email is missing");
    }

    reviewService.postReview(userEmail, reviewRequest);
  }

  @GetMapping("/secure/user/book")
  public boolean reviewBookByUser(@RequestHeader(value = "Authorization") String token,
                                  @RequestParam Long bookId) throws  Exception {

    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);

    if (userEmail == null) {
      throw new Exception("User email is missing");
    }

    return reviewService.userReviewListed(userEmail, bookId);
  }
}
