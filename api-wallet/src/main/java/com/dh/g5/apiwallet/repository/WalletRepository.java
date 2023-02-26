package com.dh.g5.apiwallet.repository;

import com.dh.g5.apiwallet.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID>, QuerydslPredicateExecutor<Wallet> {
}
