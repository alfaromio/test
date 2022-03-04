package com.melita.ordertaking.dto;

import com.melita.ordertaking.domain.OrderTakeRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderStatus {
    private OrderTakeRequest orderRequest;
    private String Status;
    private String message;
}
