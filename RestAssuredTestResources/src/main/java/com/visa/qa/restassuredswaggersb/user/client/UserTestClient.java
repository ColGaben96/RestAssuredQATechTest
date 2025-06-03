package com.visa.qa.restassuredswaggersb.user.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.user.model.User;
import io.restassured.response.Response;


import java.util.List;
import java.util.Map;

public class UserTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getUserLogin() {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/user/login",
                new java.util.ArrayList<String>() {{
                    add("username");
                    add("password");
                }},
                new java.util.ArrayList<String>() {{
                    add("username");
                    add("password");
                }},
                null
        );
    }

    public Response getUserLogout() {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/user/logout",
                new java.util.ArrayList<String>(),
                new java.util.ArrayList<String>(),
                null
        );
    }

    public Response getUserByName(String username) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/user/{username}",
                new java.util.ArrayList<String>() {{
                    add("username");
                }},
                new java.util.ArrayList<String>() {{
                    add(username);
                }},
                null
        );
    }

    public Response postUser(User user) {
        return new SwaggerRequest().postResponse(
                "localhost:8080",
                "/user",
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                user
        );
    }

    public Response postUserWithList(List<String> users) {
        return new SwaggerRequest().postResponse(
                "localhost:8080",
                "/user/createWithList",
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                users
        );
    }

    public Response putUser(String username, String user) {
        return new SwaggerRequest().putResponse(
                "localhost:8080",
                "/user/{username}",
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>() {{
                    add("username");
                }},
                user
        );
    }

    public Response deleteUser(String username) {
        return new SwaggerRequest().deleteResponse(
                "localhost:8080",
                "/user/"+username,
                new java.util.ArrayList<String>(),
                new java.util.ArrayList<String>() {{
                    add(username);
                }},
                null
        );
    }
}
