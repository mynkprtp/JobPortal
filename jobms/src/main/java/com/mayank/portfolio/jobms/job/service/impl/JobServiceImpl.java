package com.mayank.portfolio.jobms.job.service.impl;

import com.mayank.portfolio.jobms.job.clients.CompanyClient;
import com.mayank.portfolio.jobms.job.clients.ReviewClient;
import com.mayank.portfolio.jobms.job.dto.JobDTO;
import com.mayank.portfolio.jobms.job.Job;
import com.mayank.portfolio.jobms.job.external.Company;
import com.mayank.portfolio.jobms.job.external.Review;
import com.mayank.portfolio.jobms.job.mapper.JobMapper;
import com.mayank.portfolio.jobms.job.repository.JobRepository;
import com.mayank.portfolio.jobms.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
//    @Autowired
//    RestTemplate restTemplate;

    CompanyClient companyClient;
    ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository,CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
        HashMap<Integer,Integer> mp = new HashMap<>();
        Iterator
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobDTO convertToDTO(Job job){
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
        return JobMapper.mapToJobWithCompanyDTO(job,company,reviews);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO findById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job curJob = jobOptional.get();
            curJob.setDescription(job.getDescription());
            curJob.setLocation(job.getLocation());
            curJob.setTitle(job.getTitle());
            curJob.setMinSalary(job.getMinSalary());
            curJob.setMaxSalary(job.getMaxSalary());
            curJob.setLocation(job.getLocation());
            curJob.setStatus(job.getStatus());
            jobRepository.save(curJob);
            return true;
        }
        return false;
    }
}
