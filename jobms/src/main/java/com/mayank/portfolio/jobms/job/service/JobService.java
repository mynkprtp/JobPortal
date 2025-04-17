package com.mayank.portfolio.jobms.job.service;

import com.mayank.portfolio.jobms.job.dto.JobDTO;
import com.mayank.portfolio.jobms.job.Job;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO findById(Long id);
    boolean deleteById(Long id);
    boolean updateJob(Long id, Job job);
}
