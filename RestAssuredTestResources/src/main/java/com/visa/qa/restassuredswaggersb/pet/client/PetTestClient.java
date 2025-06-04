package com.visa.qa.restassuredswaggersb.pet.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants;
import com.visa.qa.restassuredswaggersb.pet.model.Pet;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants.BASE_URL;

public class PetTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getPetById(Long petId) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT+"/"+petId,
                new java.util.ArrayList<String>() {{
                    add("petId");
                }},
                new java.util.ArrayList<String>() {{
                    add("petId");
                }}
        );
    }

    public Response getPetByTags(List<String> tags) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_PET_BY_TAGS_ENDPOINT,
                new java.util.ArrayList<String>() {{
                    add("tags");
                }},
                new java.util.ArrayList<String>() {{
                    addAll(tags);
                }}
        );
    }

    public Response getPetByStatus(String status) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_PET_BY_STATUS_ENDPOINT,
                new java.util.ArrayList<String>() {{
                    add("status");
                }},
                new java.util.ArrayList<String>() {{
                    add(status);
                }}
        );
    }

    public Response putPet(Pet pet) {
        return new SwaggerRequest().putResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT,
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                pet
        );
    }

    public Response postPet(Pet pet) {
        return new SwaggerRequest().postResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT,
                new java.util.ArrayList<String>() {{
                    add("Content-Type: application/json");
                }},
                new java.util.ArrayList<String>(),
                pet
        );
    }

    public  Response deletePet(Long petId) {
        return new SwaggerRequest().deleteResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT+"/"+petId,
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
