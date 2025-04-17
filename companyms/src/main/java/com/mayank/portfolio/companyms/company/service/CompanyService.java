package com.mayank.portfolio.companyms.company.service;

import com.mayank.portfolio.companyms.company.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    boolean createCompany(Company company);
    Company getCompanyById(Long companyId);
    boolean deleteCompanyById(Long companyId);
}
