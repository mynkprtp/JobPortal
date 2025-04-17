package com.mayank.portfolio.companyms.company.service.impl;

import com.mayank.portfolio.companyms.company.Company;
import com.mayank.portfolio.companyms.company.repository.CompanyRepository;
import com.mayank.portfolio.companyms.company.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            Company updatedCompany = optionalCompany.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean createCompany(Company company) {
        try{
            companyRepository.save(company);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long companyId) {
        if(companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return true;
        }
        return false;
    }
}
