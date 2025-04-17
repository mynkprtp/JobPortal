package com.mayank.portfolio.companyms.company.repository;

import com.mayank.portfolio.companyms.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
