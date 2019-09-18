package io.boboo.api.client;

import io.boboo.api.client.constant.BobooConstants;
import io.boboo.api.client.impl.BobooApiRestClientImpl;
import io.boboo.api.client.impl.BobooApiWebSocketClientImpl;
import io.boboo.api.client.impl.BobooOptionApiRestClientImpl;

import static io.boboo.api.client.impl.BobooApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BobooApi client objects.
 */
public final class BobooApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    private String baseUrl = BobooConstants.API_BASE_URL;

    /**
     * Instantiates a new BOBOO api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BobooApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    private BobooApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the BOBOO api client factory
     */
    public static BobooApiClientFactory newInstance(String apiKey, String secret) {
        return new BobooApiClientFactory(apiKey, secret);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param baseUrl
     * @param apiKey
     * @param secret
     * @return
     */
    public static BobooApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new BobooApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the BOBOO api client factory
     */
    public static BobooApiClientFactory newInstance() {
        return new BobooApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BobooApiRestClient newRestClient() {
        return new BobooApiRestClientImpl(baseUrl, apiKey, secret);
    }


    public BobooApiWebSocketClient newWebSocketClient() {
        return new BobooApiWebSocketClientImpl(getSharedClient(), BobooConstants.WS_API_BASE_URL, BobooConstants.WS_API_USER_URL);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param wsApiBaseUrl
     * @param wsApiUserUrl
     * @return
     */
    public BobooApiWebSocketClient newWebSocketClient(String wsApiBaseUrl, String wsApiUserUrl) {
        return new BobooApiWebSocketClientImpl(getSharedClient(), wsApiBaseUrl, wsApiUserUrl);
    }

    /**
     * Creates a new synchronous/blocking Option REST client.
     */
    public BobooOptionApiRestClient newOptionRestClient() {
        return new BobooOptionApiRestClientImpl(baseUrl, apiKey, secret);
    }

}
