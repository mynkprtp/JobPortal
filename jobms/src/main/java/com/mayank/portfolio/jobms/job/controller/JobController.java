package com.mayank.portfolio.jobms.job.controller;

import com.mayank.portfolio.jobms.job.Job;
import com.mayank.portfolio.jobms.job.dto.JobDTO;
import com.mayank.portfolio.jobms.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> findById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.findById(id);
        if(jobDTO != null){
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteById(id);
        if(isDeleted)
            return ResponseEntity.ok("Job deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean isUpdated = jobService.updateJob(id, job);
        if(isUpdated)
                return ResponseEntity.ok("Job updated successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
    }

}
