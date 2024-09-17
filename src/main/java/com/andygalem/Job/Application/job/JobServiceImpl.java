package com.andygalem.Job.Application.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl  implements JobService{
    @Autowired
private JobRepository jobRepository;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
    jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if(job!=null){
            return job;
        }
        return job;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updatebyId(Long id, Job updatedJob) {
        Job job = jobRepository.findById(id).orElse(null);

            if(job!=null){
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                jobRepository.save(job);
                return true;

            }

        return false;
    }
}
