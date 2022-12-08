package com.nttdata.bootcoinpurchase.repository;

import com.nttdata.bootcoinpurchase.document.BootCoinPurchase;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootCoinPurchaseRepository extends ReactiveMongoRepository<BootCoinPurchase, String> {
}
