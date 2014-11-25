package com.javathinking.sample2.type1.transaction;

import org.joda.time.DateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Date: 8/03/2014
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByDateBetween(DateTime date1, DateTime date2, Pageable pageable);
    long countByDateBetween(DateTime date1, DateTime date2);

    @Query("select distinct client from Transaction where date between ? and ?")
    List<String> findAllDistinctClientsByDateBetween(DateTime date1, DateTime date2);


    List<Transaction> findAllByClientAndDateBetween(String client, DateTime date1, DateTime date2, Pageable pageable);
    long countByClientAndDateBetween(String client, DateTime date1, DateTime date2);
    long countByFileRefAndAmountLessThan(String ref, BigDecimal amount);

    long countByFileRef(String fileRef);

    List<Transaction> findAllByFileRefAndAmount(String fileRef, BigDecimal amount);
}
