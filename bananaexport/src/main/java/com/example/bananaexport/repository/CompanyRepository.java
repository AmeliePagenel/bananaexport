package com.example.bananaexport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bananaexport.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long > {
	
	Optional<Company> findByNameAndAddressAndPostalCodeAndCityAndCountry(String name, String address, String postalCode, String city, String country);

}
