package com.example.contaflux.repository;
import com.example.contaflux.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}

