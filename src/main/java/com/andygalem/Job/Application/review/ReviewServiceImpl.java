package com.andygalem.Job.Application.review;

import com.andygalem.Job.Application.company.Company;
import com.andygalem.Job.Application.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllreviews(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = this.getAllreviews(companyId);
        for(Review review:reviews){
            if(review.getId().equals(reviewId)){
                return review;
            }
        }
        return null;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Review review= this.getReview(companyId,reviewId);
        if(review!=null){
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());
          //  review.setCompany(updatedReview.getCompany());
            reviewRepo.save(review);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        List<Review> reviews = this.getAllreviews(companyId);
        for(Review review: reviews){
            if(review.getId().equals(reviewId)){
                reviewRepo.deleteById(reviewId);
                return true;
            }
        }
        return false;

    }
}

