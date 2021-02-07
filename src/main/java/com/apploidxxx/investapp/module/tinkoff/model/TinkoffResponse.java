package com.apploidxxx.investapp.module.tinkoff.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TinkoffResponse<T> {
    private String trackingId;
    private String status;
    private T payload;
}
