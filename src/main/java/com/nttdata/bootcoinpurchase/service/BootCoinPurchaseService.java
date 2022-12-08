package com.nttdata.bootcoinpurchase.service;

import com.nttdata.bootcoinpurchase.document.BootCoinPurchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * BootCoinPurchase service interface.
 */
public interface BootCoinPurchaseService {

    public Flux<BootCoinPurchase> findAll();

    public Mono<BootCoinPurchase> register(BootCoinPurchase bootCoinPurchase);

    public Mono<BootCoinPurchase> update(BootCoinPurchase bootCoinPurchase);

    public Mono<Void> delete(String id);

    public Mono<BootCoinPurchase> findById(String id);
}
