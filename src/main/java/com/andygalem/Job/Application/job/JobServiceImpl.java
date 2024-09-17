package com.andygalem.Job.Application.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl  implements JobService{
    private Long id =0L;

    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(++id);
     jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatebyId(Long id, Job updatedJob) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
