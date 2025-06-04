package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.pet.client.PetTestClient;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

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
}
