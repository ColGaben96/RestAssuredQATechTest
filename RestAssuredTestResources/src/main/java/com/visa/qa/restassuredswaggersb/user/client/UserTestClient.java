package com.visa.qa.restassuredswaggersb.user.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants;
import com.visa.qa.restassuredswaggersb.user.model.User;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants.BASE_URL;

public class UserTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getUserLogin() {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_USER_LOGIN_ENDPOINT,
                new HashMap<>() {{
                    put("username", "testuser");
                    put("password", "testpass");
                }}
        );
    }

    public Response getUserLogout() {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_USER_LOGOUT_ENDPOINT,
                new HashMap<>() {{
                    put("username", "testuser");
                }}
        );
    }

    public Response getUserByName(String username) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.POST_USER_ENDPOINT+"/"+username,
                new HashMap<>() {{}}
        );
    }

    public Response postUser(User user) {
        return new SwaggerRequest().postResponse(
                BASE_URL,
                EndpointConstants.POST_USER_ENDPOINT,
                new HashMap<>() {{}},
                user
        );
    }

    public Response postUserWithList(List<String> users) {
        return new SwaggerRequest().postResponse(
                BASE_URL,
                EndpointConstants.POST_USER_CREATE_WITH_LIST_ENDPOINT,
                new HashMap<>() {{}},
                users
        );
    }

    public Response putUser(String username, User user) {
        return new SwaggerRequest().putResponse(
                BASE_URL,
                EndpointConstants.POST_USER_ENDPOINT+"/"+username,
                new HashMap<>() {{}},
                user
        );
    }

    public Response deleteUser(String username) {
        return new SwaggerRequest().deleteResponse(
                BASE_URL,
                EndpointConstants.POST_USER_ENDPOINT+"/"+username,
                new HashMap<>() {{}},
                "{}"
        );
    }
}
