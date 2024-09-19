package com.andygalem.Job.Application.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
       if(companyRepository.existsById(id)){
           companyRepository.deleteById(id);
           return true;
       }
       return false;

    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company!=null){
            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean createCompany(Company company) {
        try{
            companyRepository.save(company);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
