package com.andygalem.Job.Application.review;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<List<Review>> getAllreview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllreviews(companyId), HttpStatus.OK);

    }
    @PostMapping("")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isCreated= reviewService.createReview(companyId,review);
        if(isCreated){
            return ResponseEntity.ok("Review for company ID:"+companyId+" is created");
        }
        return new ResponseEntity<>("Company Id:"+companyId+" not found, fail to create Review!!",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){
        Review ispresent = reviewService.getReview(companyId,reviewId);
        if(ispresent!=null)
    return new ResponseEntity<>(ispresent,HttpStatus.OK);
        return new ResponseEntity<Review>(ispresent,HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){

       boolean isUpdated= reviewService.updateReview(companyId,reviewId,review);

       if(isUpdated){
         return new ResponseEntity<>("review updated successfully!!",HttpStatus.OK);
       }
       return new ResponseEntity<>("Either company or review not found!!",HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean isDeleted= reviewService.deleteReview(companyId,reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Either company or review is incorrect!",HttpStatus.NOT_FOUND);

    }


}
