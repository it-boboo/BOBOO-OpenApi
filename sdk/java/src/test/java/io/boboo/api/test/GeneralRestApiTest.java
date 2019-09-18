package io.boboo.api.test;

import io.boboo.api.client.BobooApiClientFactory;
import io.boboo.api.client.BobooApiRestClient;
import io.boboo.api.client.domain.general.BrokerInfo;
import io.boboo.api.test.constant.Constants;

public class GeneralRestApiTest {

    public static void main(String[] args) {

        BobooApiClientFactory factory = BobooApiClientFactory.newInstance();
        BobooApiRestClient client = factory.newRestClient();

        System.out.println("\n ------BrokerInfo-----");
        BrokerInfo brokerInfo = client.getBrokerInfo();
        System.out.println(brokerInfo);

    }


}
