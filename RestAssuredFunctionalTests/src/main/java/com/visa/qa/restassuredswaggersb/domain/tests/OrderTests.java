package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.order.client.OrderTestClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = TestModule.class)
public class OrderTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(OrderTests.class);
    private OrderTestClient client = new OrderTestClient();

    @Test
    public void testGetOrderById() {
        log.info("Starting testGetOrderById");
        final Response response = client.getOrderId(1L);
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Finished testGetOrderById");
    }

}
