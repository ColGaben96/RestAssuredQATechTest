package com.visa.qa.restassuredswaggersb.order.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants;
import com.visa.qa.restassuredswaggersb.order.model.Order;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Map;

import static com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants.BASE_URL;

public class OrderTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getPetInventory() {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.PET_INVENTORY_ENDPOINT,
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
    public Response postOrder(Order order) {
        return new SwaggerRequest().postResponse(
                BASE_URL,
                EndpointConstants.POST_ORDER_ENDPOINT,
                new ArrayList<>(),
                new ArrayList<>(),
                order
        );
    }
    public Response getOrderId(String orderId) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.POST_ORDER_ENDPOINT+"/"+orderId,
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
    public Response deleteOrderId(String orderId) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.POST_ORDER_ENDPOINT+"/"+orderId,
                new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }
}
