package com.andygalem.Job.Application.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company updatedCompany);

    boolean createCompany(Company company);
}
