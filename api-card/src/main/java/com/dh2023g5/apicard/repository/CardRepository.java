package com.dh2023g5.apicard.repository;

import com.dh2023g5.apicard.model.TarjetaCredito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface CardRepository extends MongoRepository<TarjetaCredito,String> {
 Optional<TarjetaCredito> findByDocumentTypeAndDocumentNumber(String documentType, String documentNum);

}
