package com.visa.qa.restassuredswaggersb.common.request;


import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwaggerRequest extends RestAssured {

    public Response getResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .when()
                .get();
    }

    public Response postResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .when()
                .post();
    }
    public Response putResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .when()
                .put();
    }
    public Response deleteResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .when()
                .delete();
    }
    public Response patchResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Accept-Encoding", "UTF-8")
                .baseUri(baseUrl)
                .basePath(path)
                .when()
                .patch();
    }
}
