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
                .get(baseUrl + path);
    }

    public Response postResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("Content-Type", "application/json")
                .header("Content-Encoding", "UTF-8")
                .post(baseUrl + path);
    }
    public Response putResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Content-Encoding", "UTF-8")
                .put(baseUrl + path);
    }
    public Response deleteResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Content-Encoding", "UTF-8")
                .delete(baseUrl + path);
    }
    public Response patchResponse(String baseUrl, String path, List<String> headers, List<String> params, Object body) {
        return RestAssured
                .given()
                .body(body)
                .header("content-type", "application/json")
                .header("Content-Encoding", "UTF-8")
                .patch(baseUrl + path);
    }
}
