package com.mayank.portfolio.jobms.job.repository;

import com.mayank.portfolio.jobms.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
