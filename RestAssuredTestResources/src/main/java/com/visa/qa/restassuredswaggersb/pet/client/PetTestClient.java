package com.visa.qa.restassuredswaggersb.pet.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.request.SwaggerRequest;
import com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants;
import com.visa.qa.restassuredswaggersb.pet.model.Pet;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visa.qa.restassuredswaggersb.common.utils.EndpointConstants.BASE_URL;

public class PetTestClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<Map<String, Object>> typeRef = new TypeReference<>() {};

    public Response getPetById(Long petId) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT + "/" + petId,
                new HashMap<>(){{}}
        );
    }

    public Response getPetByTags(List<String> tags) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_PET_BY_TAGS_ENDPOINT,
                new HashMap<String, Object>() {{
                    for (String tag : tags) {
                        put("tags", tag);
                    }
                }}
        );
    }

    public Response getPetByStatus(String status) {
        return new SwaggerRequest().getResponse(
                BASE_URL,
                EndpointConstants.GET_PET_BY_STATUS_ENDPOINT,
                new HashMap<String, Object>() {{
                    put("status", status);
                }}
        );
    }

    public Response putPet(Pet pet) {
        return new SwaggerRequest().putResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT,
                new HashMap<>(){{}},
                pet
        );
    }

    public Response postPet(Pet pet) {
        return new SwaggerRequest().postResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT,
                new HashMap<>(){{}},
                pet
        );
    }

    public  Response deletePet(Long petId) {
        return new SwaggerRequest().deleteResponse(
                BASE_URL,
                EndpointConstants.PUT_PET_ENDPOINT+"/"+petId,
                new HashMap<>(){{}},
                "{}"
        );
    }
}
