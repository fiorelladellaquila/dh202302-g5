package com.dh2023g5.apicard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends MongoRepository<MovimientosRepository,String> {
}
