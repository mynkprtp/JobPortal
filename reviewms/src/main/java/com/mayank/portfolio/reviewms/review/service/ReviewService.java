package com.mayank.portfolio.reviewms.review.service;


import com.mayank.portfolio.reviewms.review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long reviewId);
    boolean updateReview(Review review, Long reviewId);
    boolean deleteReview(Long reviewId);
}
