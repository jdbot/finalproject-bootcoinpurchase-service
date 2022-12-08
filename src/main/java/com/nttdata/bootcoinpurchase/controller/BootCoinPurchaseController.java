package com.nttdata.bootcoinpurchase.controller;

import com.nttdata.bootcoinpurchase.document.BootCoinPurchase;
import com.nttdata.bootcoinpurchase.service.BootCoinPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller of BootCoinPurchase.
 */
@RestController
@RequestMapping("/bootcoinpurchase")
public class BootCoinPurchaseController {

    @Autowired
    private BootCoinPurchaseService bootCoinPurchaseService;

    //Method to get all the BootCoinPurchase
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootCoinPurchase> findAll() {
        return bootCoinPurchaseService.findAll();
    }

    //Method to insert a new BootCoinPurchase
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurchase> register(@RequestBody BootCoinPurchase bootCoinPurchase) {
        return  bootCoinPurchaseService.register(bootCoinPurchase);
    }

    //Method to update a BootCoinPurchase
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurchase> modify(@RequestBody BootCoinPurchase bootCoinPurchase) {
        return  bootCoinPurchaseService.update(bootCoinPurchase);
    }

    //Method to get a BootCoinPurchase by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurchase> findById(@PathVariable("id") String id) {
        return bootCoinPurchaseService.findById(id);
    }

    //Method to delete a BootCoinPurchase
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") String id) {
        return bootCoinPurchaseService.delete(id);
    }
}
