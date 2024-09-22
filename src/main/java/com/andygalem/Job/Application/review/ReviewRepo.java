package com.andygalem.Job.Application.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}
