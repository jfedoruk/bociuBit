package com.bociu;

import com.bociu.dto.BitMarketAccountInfoResponse;
import com.bociu.dto.BitMarketTicker;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class bociuBitApp {

    private static final String privateKey = "fe5d63a3f075dd35f62913c2a1432d82";
    private static final String secretKey = "1d8a5c5d7c9959f56a15e6aa5a920d92";

    private static BitMarket bitMarket = RestProxyFactory.createProxy(BitMarket.class, "https://www.bitmarket.pl");
    private static BitMarketAuth bitMarketAuth = RestProxyFactory.createProxy(BitMarketAuth.class, "https://www.bitmarket.pl");
    private static ParamsDigest signer = BitMarketDigest.createInstance(secretKey);
    private TimestampIncrementingNonceFactory nonceFactory = new TimestampIncrementingNonceFactory();

    public static void main(String[] args) {
        System.out.println("Start");
        bociuBitApp bot = new bociuBitApp();
        bot.getTick();
        bot.getAccountInfo();
    }


    public String getTick() {
        String tick = null;
        try {
            BitMarketTicker ticker = bitMarket.getTicker("BTCPLN");
            tick = ticker.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tick;
    }

    public String getAccountInfo() {
        String accountInfo = null;

        try {
            BitMarketAccountInfoResponse bitMarketAccountInfo = bitMarketAuth.info(privateKey, signer, nonceFactory);
            sleep(6000);
            bitMarketAccountInfo = bitMarketAuth.info(privateKey, signer, nonceFactory);
            accountInfo = bitMarketAccountInfo.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accountInfo;
    }


}
