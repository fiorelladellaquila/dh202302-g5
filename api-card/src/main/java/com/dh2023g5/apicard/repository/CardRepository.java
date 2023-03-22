package com.dh2023g5.apicard.repository;

import com.dh2023g5.apicard.model.TarjetaCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CardRepository extends MongoRepository<TarjetaCredito,String> {



}
