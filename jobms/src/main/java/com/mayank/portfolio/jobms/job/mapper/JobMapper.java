package com.mayank.portfolio.jobms.job.mapper;

import com.mayank.portfolio.jobms.job.Job;
import com.mayank.portfolio.jobms.job.dto.JobDTO;
import com.mayank.portfolio.jobms.job.external.Company;
import com.mayank.portfolio.jobms.job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setStatus(job.getStatus());
        jobDTO.setCompany(company);
        jobDTO.setReview(reviews);
        return jobDTO;
    }
}
