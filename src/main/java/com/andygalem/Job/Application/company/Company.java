package com.andygalem.Job.Application.company;

import com.andygalem.Job.Application.job.Job;
import com.andygalem.Job.Application.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    //this means company table has relationship with job table
    // job table has  company column
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company() {

    }

    @JsonIgnore
    // JsonIgnore is used to stop serialization and deserialization
    // it will not have any impact on DB
    // but in post-man it will be a infinite loop..
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
