package com.mayank.portfolio.reviewms.review.controller;

import com.mayank.portfolio.reviewms.review.Review;
import com.mayank.portfolio.reviewms.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        List<Review> reviews = reviewService.getAllReviews(companyId);
        if(!reviews.isEmpty()){
            return ResponseEntity.ok(reviews);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
        boolean isCreated = reviewService.addReview(companyId, review);
        if(isCreated){
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add review", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        Review review = reviewService.getReview(reviewId);
        if(review != null){
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(review,reviewId);
        if(isUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to update review", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(reviewId);
        if(isDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to deleted review", HttpStatus.NOT_FOUND);
    }
}
