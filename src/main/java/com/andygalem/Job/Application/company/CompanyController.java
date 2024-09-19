package com.andygalem.Job.Application.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public ResponseEntity<List<Company>> getAll() {
       List<Company> companies = companyService.findAll();
       if(companies!=null){
           return new ResponseEntity<>(companies, HttpStatus.OK);
    }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeById(@PathVariable Long id){
        boolean isDeleted= companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("company with id:"+id+" is Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updatedCompany){
        boolean isUpdated = companyService.updateCompany(id,updatedCompany);
        if(isUpdated){
            return new ResponseEntity<>("Company with id:"+id+" is updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company with id:"+id+" not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        boolean isCreated = companyService.createCompany(company);
        if(isCreated){
            return new ResponseEntity<>("Company created successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
