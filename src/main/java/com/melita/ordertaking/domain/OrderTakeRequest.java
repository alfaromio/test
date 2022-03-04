package com.melita.ordertaking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderTakeRequest {
    private String orderID;
    private String cutomerNIC;//customer national identity card number
    private String customerName;
    private String installationAddress;
    private String preferredInstDateTme;
    private String requiredProduct;
    private String requiredPackage;
    private String requestedTime;
}
