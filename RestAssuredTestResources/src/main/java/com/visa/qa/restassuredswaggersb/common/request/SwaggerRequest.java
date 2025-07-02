package com.visa.qa.restassuredswaggersb.common.request;


import io.restassured.RestAssured;

import io.restassured.response.Response;


import java.util.Map;

public class SwaggerRequest extends RestAssured {

    public Response getResponse(String baseUrl, String path, Map<String, Object> params) {
        return RestAssured
                .given()
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .queryParams(params)
                .when()
                .get();
    }

    public Response postResponse(String baseUrl, String path, Map<String, Object> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .queryParams(params)
                .when()
                .post();
    }
    public Response putResponse(String baseUrl, String path, Map<String, Object> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .queryParams(params)
                .when()
                .put();
    }
    public Response deleteResponse(String baseUrl, String path, Map<String, Object> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .queryParams(params)
                .when()
                .delete();
    }
    public Response patchResponse(String baseUrl, String path, Map<String, Object> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .queryParams(params)
                .when()
                .patch();
    }
}
