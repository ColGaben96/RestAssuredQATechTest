package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.pet.client.PetTestClient;
import com.visa.qa.restassuredswaggersb.pet.model.Pet;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Guice(modules = TestModule.class)
public class PetTests extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(PetTests.class);
    private PetTestClient petTestClient = new PetTestClient();

    @Test
    public void testGetPetById() {
        log.info("Starting testGetPetById");
        final Response response = petTestClient.getPetById(1L);
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Finished testGetPetById");
    }

    @Test
    public void testPostPet() {
        log.info("Starting testPostPet");
        final Response response = petTestClient.postPet(new Pet().builder()
                .id(2L)
                .name("NewPet")
                .status("available")
                .build());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().print().contains("NewPet"));
        log.info("Finished testPostPet");
    }

    @Test
    public void testGetByStatus() {
        log.info("Starting testGetByStatus");
        final Response response = petTestClient.getPetByStatus("available");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().print().contains("available"));
        log.info("Finished testGetByStatus");
    }

    @Test
    public void testUpdatePet() {
        log.info("Starting testUpdatePet");
        final Response response = petTestClient.putPet(new Pet().builder()
                .id(1L)
                .name("UpdatedPet")
                .status("sold")
                .build());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().print().contains("UpdatedPet"));
        log.info("Finished testUpdatePet");
    }

    @Test
    public void testGetPetByTags() {
        log.info("Starting testGetPetByTags");
        final Response response = petTestClient.getPetByTags(new ArrayList<String>() {{;
            add("tag1");
            add("tag2");
        }});
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().print().contains("tag1"));
        Assert.assertTrue(response.getBody().print().contains("tag2"));
        log.info("Finished testGetPetByTags");
    }

    @Test
    public void testDeletePet() {
        log.info("Starting testDeletePet");
        final Response response = petTestClient.deletePet(2L);
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Finished testDeletePet");
    }
}
