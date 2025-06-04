package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.user.client.UserTestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = TestModule.class)
public class UserTests extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(UserTests.class);
    private UserTestClient userTestClient = new UserTestClient();

    @Test
    public void testGetUserByUsername() {
        log.info("Starting testGetUserByUsername");
        final String username = "testUser";
        final var response = userTestClient.getUserByName(username);
        if (response.getStatusCode() == 200) {
            log.info("User found: {}", response.getBody().asString());
        } else {
            log.error("Failed to retrieve user: {}", response.getStatusLine());
        }
        log.info("Finished testGetUserByUsername");
    }
}
