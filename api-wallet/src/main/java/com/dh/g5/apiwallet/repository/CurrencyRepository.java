package com.dh.g5.apiwallet.repository;

import com.dh.g5.apiwallet.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}
