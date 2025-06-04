package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.order.client.OrderTestClient;
import com.visa.qa.restassuredswaggersb.order.model.Order;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.Map;

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

    @Test
    public void testPostOrder() {
        log.info("Starting testPostOrder");
        final Response response = client.postOrder(new Order().builder()
                .id(2L)
                .petId(1L)
                .quantity(2)
                .shipDate("2023-10-01T00:00:00Z")
                .status("placed")
                .complete(true)
                .build());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().print().contains(client.getOrderId(2L).getBody().print()));
        log.info("Finished testPostOrder");
    }

    @Test
    public void testGetInventory() {
        log.info("Starting testGetInventory");
        final Response response = client.getPetInventory();
        Assert.assertEquals(response.getStatusCode(), 200);
        var inventory = response.getBody().as(Map.class);
        Assert.assertEquals(inventory.get("placed"), 6);
        Assert.assertEquals(inventory.get("delivered"), 50);
        log.info("Finished testGetInventory");
    }

    @Test
    public void testDeleteOrder() {
        log.info("Starting testDeleteOrder");
        final Response response = client.deleteOrderId(2L);
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Finished testDeleteOrder");
    }

}
