package com.visa.qa.restassuredswaggersb.pet.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.pet.model.Pet;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class PetTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getPetById(String petId) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/pet/"+petId,
                new java.util.ArrayList<String>() {{
                    add("petId");
                }},
                new java.util.ArrayList<String>() {{
                    add("petId");
                }},
                null
        );
    }

    public Response getPetByTags(List<String> tags) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/pet/findByTags",
                new java.util.ArrayList<String>() {{
                    add("tags");
                }},
                new java.util.ArrayList<String>() {{
                    addAll(tags);
                }},
                null
        );
    }

    public Response getPetByStatus(String status) {
        return new SwaggerRequest().getResponse(
                "localhost:8080",
                "/pet/findByStatus",
                new java.util.ArrayList<String>() {{
                    add("status");
                }},
                new java.util.ArrayList<String>() {{
                    add(status);
                }},
                null
        );
    }

    public Response putPet(Pet pet) {
        return new SwaggerRequest().putResponse(
                "localhost:8080",
                "/pet",
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                pet
        );
    }

    public Response postPet(Pet pet) {
        return new SwaggerRequest().postResponse(
                "localhost:8080",
                "/pet",
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                pet
        );
    }

    public  Response deletePet(String petId) {
        return new SwaggerRequest().deleteResponse(
                "localhost:8080",
                "/pet/"+petId,
                new java.util.ArrayList<String>() {{
                    add("petId");
                }},
                new java.util.ArrayList<String>() {{
                    add("petId");
                }},
                null
        );
    }
}
