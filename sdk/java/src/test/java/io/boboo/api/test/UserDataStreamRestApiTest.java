package io.boboo.api.test;

import io.boboo.api.client.BobooApiClientFactory;
import io.boboo.api.client.BobooApiRestClient;
import io.boboo.api.client.constant.BobooConstants;
import io.boboo.api.test.constant.Constants;

public class UserDataStreamRestApiTest {

    public static void main(String[] args) {

        BobooApiClientFactory factory = BobooApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        BobooApiRestClient client = factory.newRestClient();

        System.out.println("\n ------start user data stream-----");
        String listenKey = client.startUserDataStream(BobooConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(listenKey);

        System.out.println("\n ------keepAlive user data stream-----");
        client.keepAliveUserDataStream(listenKey, BobooConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

        System.out.println("\n ------close user data stream-----");
        client.closeUserDataStream(listenKey, BobooConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

    }

}
