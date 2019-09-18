package io.boboo.api.client.impl;

import io.boboo.api.client.BobooApiRestClient;
import io.boboo.api.client.constant.BobooConstants;
import io.boboo.api.client.domain.account.*;
import io.boboo.api.client.domain.account.request.*;
import io.boboo.api.client.domain.general.BrokerInfo;
import io.boboo.api.client.domain.market.*;
import io.boboo.api.client.service.BobooApiService;

import java.util.List;

import static io.boboo.api.client.impl.BobooApiServiceGenerator.createService;
import static io.boboo.api.client.impl.BobooApiServiceGenerator.executeSync;

/**
 * Implementation of BOBOO's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BobooApiRestClientImpl implements BobooApiRestClient {

    private final BobooApiService boBooApiService;

    public BobooApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        boBooApiService = createService(baseUrl, BobooApiService.class, apiKey, secret);
    }

    // General endpoints

    @Override
    public void ping() {
        executeSync(boBooApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return executeSync(boBooApiService.getServerTime()).getServerTime();
    }

    @Override
    public BrokerInfo getBrokerInfo() {
        return executeSync(boBooApiService.getBrokerInfo());
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return executeSync(boBooApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getTrades(String symbol, Integer limit) {
        return executeSync(boBooApiService.getTrades(symbol, limit));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit) {
        return executeSync(boBooApiService.getCandlestickBars(symbol, interval.getIntervalId(), startTime, endTime, limit));
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return executeSync(boBooApiService.get24HrPriceStatistics(symbol));
    }

    @Override
    public TickerPrice getPrice(String symbol) {
        return executeSync(boBooApiService.getLatestPrice(symbol));
    }

    @Override
    public BookTicker getBookTicker(String symbol) {
        return executeSync(boBooApiService.getBookTicker(symbol));
    }

    @Override
    public Index getIndex(String symbol) {
        return executeSync(boBooApiService.getIndex(symbol));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return executeSync(boBooApiService.newOrder(order.getSymbol(), order.getSide(), order.getType(),
                order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
                order.getIcebergQty(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(boBooApiService.getOrderStatus(orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(boBooApiService.cancelOrder(cancelOrderRequest.getOrderId(), cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getOpenOrders(OpenOrderRequest orderRequest) {
        return executeSync(boBooApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getLimit(),
                orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getHistoryOrders(HistoryOrderRequest orderRequest) {
        return executeSync(boBooApiService.getHistroyOrders(orderRequest.getOrderId(), orderRequest.getStartTime(), orderRequest.getEndTime(),
                orderRequest.getLimit(), orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public Account getAccount(Long recvWindow, Long timestamp) {
        return executeSync(boBooApiService.getAccount(recvWindow, timestamp));
    }

    @Override
    public List<Trade> getMyTrades(MyTradeRequest request) {
        return executeSync(boBooApiService.getMyTrades(request.getFromId(), request.getToId(), request.getStartTime(), request.getEndTime(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public List<DepositOrder> getDepositOrders(DepositOrderRequest request) {
        return executeSync(boBooApiService.getDepositOrders(request.getToken(), request.getStartTime(), request.getEndTime(), request.getFromId(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public String startUserDataStream(Long recvWindow, Long timestamp) {
        return executeSync(boBooApiService.startUserDataStream(recvWindow, timestamp)).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        executeSync(boBooApiService.keepAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

    @Override
    public void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        executeSync(boBooApiService.closeAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

}
