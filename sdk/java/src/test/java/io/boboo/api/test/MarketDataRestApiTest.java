package io.boboo.api.test;

import io.boboo.api.client.BobooApiClientFactory;
import io.boboo.api.client.BobooApiRestClient;
import io.boboo.api.client.domain.market.*;
import io.boboo.api.test.constant.Constants;

import java.util.List;

public class MarketDataRestApiTest {


    public static void main(String[] args) {

        BobooApiClientFactory factory = BobooApiClientFactory.newInstance();
        BobooApiRestClient client = factory.newRestClient();
        String symbol = "BTCUSDT";


        System.out.println("\n ------Ping-----");
        client.ping();

        System.out.println("\n ------serverTime-----");
        long serverTime = client.getServerTime();
        System.out.println(serverTime);

        System.out.println("\n ------get order book-----");
        OrderBook orderBook = client.getOrderBook(symbol, 100);
        System.out.println(orderBook);

        System.out.println("\n ------get recent trades-----");
        List<TradeHistoryItem> tradeHistoryItemList = client.getTrades(symbol, 10);
        System.out.println(tradeHistoryItemList);

        System.out.println("\n ------get klines-----");
        List<Candlestick> candlestickList = client.getCandlestickBars(symbol, CandlestickInterval.ONE_MINUTE, 0l, 0L, 0);
        System.out.println(candlestickList);

        System.out.println("\n ------get 24h ticker-----");
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);
        System.out.println(tickerStatistics);

        System.out.println("\n ------get ticker price-----");
        TickerPrice tickerPrice = client.getPrice(symbol);
        System.out.println(tickerPrice);

        System.out.println("\n ------get book ticker-----");
        BookTicker bookTickerList = client.getBookTicker(symbol);
        System.out.println(bookTickerList);

        System.out.println("\n ------get index-----");
        Index index = client.getIndex(symbol);
        System.out.println(index);
    }
}
