package com.visa.qa.restassuredswaggersb.order.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.order.model.Order;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Map;

public class OrderTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getPetInventory() {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/store/inventory",
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
    public Response postOrder(Order order) {
        return new SwaggerRequest().postResponse(
                "localhost:8080",
                "/store/order",
                new ArrayList<>(),
                new ArrayList<>(),
                order
        );
    }
    public Response getOrderId(String orderId) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/store/order/"+orderId,
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
    public Response deleteOrderId(String orderId) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/store/order/"+orderId,
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
}
