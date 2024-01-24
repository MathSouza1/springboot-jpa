package com.matheuscardoso.course.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    public static OrderStatus valueOf(int code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getCode() == code){
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
