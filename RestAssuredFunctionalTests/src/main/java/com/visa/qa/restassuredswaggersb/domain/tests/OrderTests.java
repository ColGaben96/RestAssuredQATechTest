package com.visa.qa.restassuredswaggersb.domain.tests;

import com.google.inject.Inject;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.order.client.OrderTestClient;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.core.SerenityReports;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;

@Guice(modules = TestModule.class)
public class OrderTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(OrderTests.class);
    private final OrderTestClient client = new OrderTestClient();

    @Test
    public void testGetOrderById() {
        log.info("Starting testGetOrderById");
        final Response response = client.getOrderId("1");


        log.info("Finished testGetOrderById");
    }

}
