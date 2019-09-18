package io.boboo.api.client.impl;

import java.util.List;

import io.boboo.api.client.BobooOptionApiRestClient;
import io.boboo.api.client.constant.BobooConstants;
import io.boboo.api.client.domain.account.request.CancelOrderRequest;
import io.boboo.api.client.domain.option.OptionMatchResult;
import io.boboo.api.client.domain.option.OptionOrderResult;
import io.boboo.api.client.domain.option.PositionResult;
import io.boboo.api.client.domain.option.SettlementResult;
import io.boboo.api.client.domain.option.TokenOptionResult;
import io.boboo.api.client.domain.option.request.OptionHistoryOrderRequest;
import io.boboo.api.client.domain.option.request.OptionOpenOrderRequest;
import io.boboo.api.client.domain.option.request.OptionOrderRequest;
import io.boboo.api.client.domain.option.request.OptionPositionRequest;
import io.boboo.api.client.domain.option.request.OptionSettlementRequest;
import io.boboo.api.client.domain.option.request.OptionTradeRequest;
import io.boboo.api.client.domain.option.request.OptionsRequest;
import io.boboo.api.client.service.BobooOptionApiService;

import static io.boboo.api.client.impl.BobooApiServiceGenerator.createService;
import static io.boboo.api.client.impl.BobooApiServiceGenerator.executeSync;

/**
 * Implementation of BOBOO's Option REST API using Retrofit with synchronous/blocking method calls.
 */
public class BobooOptionApiRestClientImpl implements BobooOptionApiRestClient {

    private final BobooOptionApiService boBooOptionApiService;

    public BobooOptionApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        boBooOptionApiService = createService(baseUrl, BobooOptionApiService.class, apiKey, secret);
    }

    @Override
    public List<TokenOptionResult> getOptions(OptionsRequest request) {
        return executeSync(boBooOptionApiService.getOptions(request.getExpired()));
    }

    @Override
    public OptionOrderResult newOptionOrder(OptionOrderRequest request) {
        return executeSync(boBooOptionApiService.newOptionOrder(
                request.getSymbol(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getOrderType() == null ? "" : request.getOrderType().name(),
                request.getTimeInForce().name(),
                request.getQuantity(),
                request.getPrice(),
                request.getClientOrderId(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public OptionOrderResult cancelOptionOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(boBooOptionApiService.cancelOptionOrder(
                cancelOrderRequest.getOrderId(),
                cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(),
                cancelOrderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionOpenOrders(OptionOpenOrderRequest orderRequest) {
        return executeSync(boBooOptionApiService.getOptionOpenOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getLimit(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionHistoryOrders(OptionHistoryOrderRequest orderRequest) {
        return executeSync(boBooOptionApiService.getOptionHistoryOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit(),
                orderRequest.getOrderStatus() == null ? "" : orderRequest.getOrderStatus().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionMatchResult> getOptionMyTrades(OptionTradeRequest request) {
        return executeSync(boBooOptionApiService.getOptionMyTrades(
                request.getSymbol(),
                request.getFromId(),
                request.getToId(),
                request.getLimit(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<PositionResult> getOptionPositions(OptionPositionRequest request) {
        return executeSync(boBooOptionApiService.getOptionPositions(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<SettlementResult> getOptionSettlements(OptionSettlementRequest request) {
        return executeSync(boBooOptionApiService.getOptionSettlements(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }
}
