package com.example.contaflux.repository;

import com.example.contaflux.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByNit(String nit);
}
