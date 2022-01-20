package com.transaction;

import lombok.Data;

/**
 * @author zetu
 * @date 2022/1/18
 */
@Data
public class TransactionEvent {
    private String eventType;

    private Runnable runnable;
}
