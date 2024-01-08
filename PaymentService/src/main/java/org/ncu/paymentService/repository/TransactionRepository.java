package org.ncu.paymentService.repository;

import org.ncu.paymentService.entity.TransactionDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsInfo, Integer>{

}
