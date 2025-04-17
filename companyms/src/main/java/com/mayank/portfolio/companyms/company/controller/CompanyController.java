package com.mayank.portfolio.companyms.company.controller;

import com.mayank.portfolio.companyms.company.Company;
import com.mayank.portfolio.companyms.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id) {
        boolean isUpdated = companyService.updateCompany(company, id);
        if(isUpdated)
            return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to update !!", HttpStatus.BAD_REQUEST );
    }

    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        boolean isCreated = companyService.createCompany(company);
        if(isCreated){
            return new ResponseEntity<>("Company created Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add company", HttpStatus.BAD_REQUEST );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if(isDeleted)
            return new ResponseEntity<>("Company deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to delete company", HttpStatus.BAD_REQUEST );
    }
}
