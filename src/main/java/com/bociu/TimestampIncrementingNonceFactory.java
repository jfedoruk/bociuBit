package com.bociu;

import si.mazi.rescu.SynchronizedValueFactory;

public class TimestampIncrementingNonceFactory implements SynchronizedValueFactory<Long> {

    private long lastNonce = 0;
    private long timeDiff = 0;

    public void setDiff(Long time){
        timeDiff = time;
    }
    public Long createValue() {
        return (System.currentTimeMillis() / 1000L) + timeDiff;
    }
}