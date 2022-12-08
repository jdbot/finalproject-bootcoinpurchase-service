package com.nttdata.bootcoinpurchase.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcoinpurchase.document.BootCoinPurchase;
import com.nttdata.bootcoinpurchase.dto.BootCoinPurchaseDto;
import com.nttdata.bootcoinpurchase.repository.BootCoinPurchaseRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }
    @Autowired
    private BootCoinPurchaseRepository bootCoinPurchaseRepository;

    @KafkaListener(topics = "bootcoin-purchase" , groupId = "default")
    public void receiveBootCoinPurchase(String message) throws JsonProcessingException {
        BootCoinPurchaseDto purchaseDto = objectMapper.readValue(message,BootCoinPurchaseDto.class);
        BootCoinPurchase purchase = modelMapper.map(purchaseDto, BootCoinPurchase.class);//new BootCoinPurchase(null,purchaseDto.getBootCoinPurchaseAmount() , false, purchaseDto.getBootCoinPurseId());
        bootCoinPurchaseRepository.save(purchase).subscribe();
    }

    @KafkaListener(topics = "purchase-confirmation" , groupId = "default")
    public void receiveConfirmationToPurchase(String message) throws JsonProcessingException {
        bootCoinPurchaseRepository.findById(message).subscribe(purchase -> {
            purchase.setAttended(true);
            bootCoinPurchaseRepository.save(purchase).subscribe();
        });
    }
}
