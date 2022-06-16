package com.example.bananaexport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bananaexport.exception.CompanyAlreadyExistsException;
import com.example.bananaexport.entity.Company;
import com.example.bananaexport.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getCompanies() {
		return companyRepository.findAll();
	}

	public Company addCompany(Company company) {
		Optional<Company> companyInDb = companyRepository.findByNameAndAddressAndPostalCodeAndCityAndCountry(
				company.getName(), company.getAddress(), company.getPostalCode(), company.getCity(),
				company.getCountry());
		if (companyInDb.isPresent()) {
			throw new CompanyAlreadyExistsException("This company already exists");
		} else {
			return companyRepository.save(company);
		}

	}

	public Optional<Company> updateCompany(Long id, Company updatedCompany) {
		return companyRepository.findById(id).map(company -> {
			company.setName(updatedCompany.getName());
			company.setAddress(updatedCompany.getAddress());
			company.setPostalCode(updatedCompany.getPostalCode());
			company.setCity(updatedCompany.getCity());
			company.setCountry(updatedCompany.getCountry());
			return companyRepository.save(company);
		});
	}

	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
	}

}
