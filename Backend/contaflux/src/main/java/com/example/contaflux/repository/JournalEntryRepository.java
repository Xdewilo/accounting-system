package com.example.contaflux.repository;

import com.example.contaflux.model.JournalEntry;
import org.springframework.data.repository.CrudRepository;

public interface JournalEntryRepository extends CrudRepository<JournalEntry, Long> {
}
