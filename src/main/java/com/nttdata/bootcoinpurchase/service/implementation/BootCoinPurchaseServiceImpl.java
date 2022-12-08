package com.nttdata.bootcoinpurchase.service.implementation;

import com.nttdata.bootcoinpurchase.document.BootCoinPurchase;
import com.nttdata.bootcoinpurchase.repository.BootCoinPurchaseRepository;
import com.nttdata.bootcoinpurchase.service.BootCoinPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinPurchaseServiceImpl implements BootCoinPurchaseService {

    @Autowired
    BootCoinPurchaseRepository bootCoinPurchaseRepository;


    @Override
    public Flux<BootCoinPurchase> findAll() {
        return bootCoinPurchaseRepository.findAll();
    }

    @Override
    public Mono<BootCoinPurchase> register(BootCoinPurchase bootCoinPurchase) {
        return bootCoinPurchaseRepository.save(bootCoinPurchase);
    }

    @Override
    public Mono<BootCoinPurchase> update(BootCoinPurchase bootCoinPurchase) {
        return bootCoinPurchaseRepository.save(bootCoinPurchase);
    }

    @Override
    public Mono<Void> delete(String id) {
        return bootCoinPurchaseRepository.deleteById(id);
    }

    @Override
    public Mono<BootCoinPurchase> findById(String id) {
        return bootCoinPurchaseRepository.findById(id);
    }
}
