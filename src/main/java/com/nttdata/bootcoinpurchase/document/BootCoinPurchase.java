package com.nttdata.bootcoinpurchase.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * BootCoinPurchase document.
 */
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Document(collection = "bootcoinpurchases")
public class BootCoinPurchase {

    @Id
    private String id;

    private float bootCoinPurchaseAmount;
    private boolean attended;
    private String bootCoinPurseId;
}
