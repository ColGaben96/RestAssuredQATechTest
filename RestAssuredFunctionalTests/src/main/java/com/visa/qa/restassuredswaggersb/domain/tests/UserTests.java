package com.visa.qa.restassuredswaggersb.domain.tests;

import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import com.visa.qa.restassuredswaggersb.user.client.UserTestClient;
import com.visa.qa.restassuredswaggersb.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void testCreateUser() {
        log.info("Starting testCreateUser");
        final var user = User.builder()
                .id(2L)
                .username("newUser")
                .firstName("New")
                .lastName("User")
                .email("aaa@mail.com")
                .build();
        final var response = userTestClient.postUser(user);
        if (response.getStatusCode() == 200) {
            log.info("User created successfully: {}", response.getBody().asString());
        } else {
            log.error("Failed to create user: {}", response.getStatusLine());
        }
    }

    @Test
    public void testUpdateUser() {
        log.info("Starting testUpdateUser");
        final User user = User.builder()
                .id(1L)
                .username("updatedUser")
                .firstName("Updated")
                .lastName("User")
                .email("aab@mail.com")
                .build();
        final var response = userTestClient.putUser(user.getUsername(), user);
        if (response.getStatusCode() == 200) {
            log.info("User updated successfully: {}", response.getBody().asString());
        } else {
            log.error("Failed to update user: {}", response.getStatusLine());
        }
    }

    @Test
    public void testDeleteUser() {
        log.info("Starting testDeleteUser");
        final String username = "testUser";
        final var response = userTestClient.deleteUser(username);
        if (response.getStatusCode() == 200) {
            log.info("User deleted successfully: {}", response.getBody().asString());
        } else {
            log.error("Failed to delete user: {}", response.getStatusLine());
        }
    }

    @Test
    public void testGetUserLogin() {
        log.info("Starting testGetUserLogin");
        final var response = userTestClient.getUserLogin();
        if (response.getStatusCode() == 200) {
            log.info("User login successful: {}", response.getBody().asString());
        } else {
            log.error("Failed to login user: {}", response.getStatusLine());
        }
        log.info("Finished testGetUserLogin");
    }

    @Test
    public void testGetUserLogout() {
        log.info("Starting testGetUserLogout");
        final var response = userTestClient.getUserLogout();
        if (response.getStatusCode() == 200) {
            log.info("User logout successful: {}", response.getBody().asString());
        } else {
            log.error("Failed to logout user: {}", response.getStatusLine());
        }
        log.info("Finished testGetUserLogout");
    }

    @Test
    public void testPostUserWithList() {
        log.info("Starting testPostUserWithList");
        final var users = List.of("user1", "user2", "user3");
        final var response = userTestClient.postUserWithList(users);
        if (response.getStatusCode() == 200) {
            log.info("Users created successfully: {}", response.getBody().asString());
        } else {
            log.error("Failed to create users: {}", response.getStatusLine());
        }
        log.info("Finished testPostUserWithList");
    }

}
