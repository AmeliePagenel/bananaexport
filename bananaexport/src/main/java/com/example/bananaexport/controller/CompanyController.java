package com.example.bananaexport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bananaexport.entity.Company;
import com.example.bananaexport.service.CompanyService;


@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path="companies")
	public List<Company> getCompanies() {
		return companyService.getCompanies();
	}
	
	@PostMapping(path="companies")
	public Company addCompany(@RequestBody Company company) {
		return companyService.addCompany(company);
	}
	
	@PutMapping(path = "companies/{id}")
	public Optional<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
		return companyService.updateCompany(id, company);
	}
	
	@DeleteMapping(path= "companies/{id}")
	public void deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
	}
	

}
