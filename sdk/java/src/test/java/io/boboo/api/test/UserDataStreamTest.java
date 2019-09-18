package io.boboo.api.test;

import io.boboo.api.client.BobooApiClientFactory;
import io.boboo.api.client.BobooApiRestClient;
import io.boboo.api.client.BobooApiWebSocketClient;
import io.boboo.api.client.constant.BobooConstants;
import io.boboo.api.test.constant.Constants;

//@Slf4j
public class UserDataStreamTest {

    public static void main(String[] args) {
//
        BobooApiWebSocketClient client = BobooApiClientFactory.newInstance().newWebSocketClient();
        BobooApiRestClient restClient = BobooApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY).newRestClient();

        System.out.println("\n ------Get Listen Key -----");
        System.out.println();
        String listenKey = restClient.startUserDataStream(BobooConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println("listenKey:" + listenKey);
        // order
        client.onUserEvent(listenKey, response -> System.out.println(response), true);

    }
}
