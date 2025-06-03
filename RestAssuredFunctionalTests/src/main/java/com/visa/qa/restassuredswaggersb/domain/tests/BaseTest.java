package com.visa.qa.restassuredswaggersb.domain.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.qa.restassuredswaggersb.common.utils.Category;
import com.visa.qa.restassuredswaggersb.common.utils.Tag;
import com.visa.qa.restassuredswaggersb.order.client.OrderTestClient;
import com.visa.qa.restassuredswaggersb.order.model.Order;
import com.visa.qa.restassuredswaggersb.pet.client.PetTestClient;
import com.visa.qa.restassuredswaggersb.pet.model.Pet;
import com.visa.qa.restassuredswaggersb.user.client.UserTestClient;
import com.visa.qa.restassuredswaggersb.user.model.User;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    //protected final ObjectMapper objectMapper;
    protected final List<String> createdEntities = new ArrayList<>();
    protected final OrderTestClient orderTestClient = new OrderTestClient();
    protected final UserTestClient userTestClient = new UserTestClient();
    protected final PetTestClient petTestClient = new PetTestClient();

    @Before
    public void dataCreation() {
        log.info("Creating data");
        log.info("Creating User");
        userTestClient.postUser(new User().builder()
                .id(1)
                .username("testUser")
                .firstName("Test")
                .lastName("User")
                .email("geblarot96@gmail.com")
                .phone("1234567890")
                .password("12345")
                .userStatus(1)
                .build()
        );
        log.info("User created successfully!");
        log.info("Creating Pet");
        petTestClient.postPet(new Pet().builder()
                .id(1L)
                .name("TestPet")
                        .status("available")
                        .category(new Category().builder()
                                .id(1L)
                                .name("TestCategory")
                                .build())
                        .photoUrls(new ArrayList<String>() {{
                            add("http://example.com/photo1.jpg");
                            add("http://example.com/photo2.jpg");
                        }})
                        .tags(new ArrayList<Tag>() {{
                            add(new Tag().builder()
                                    .id(1L)
                                    .name("TestTag")
                                    .build());
                            add(new Tag().builder()
                                    .id(2L)
                                    .name("AnotherTag")
                                    .build());
                        }})
                .build());
        log.info("Pet created successfully!");
        log.info("Creating Order");
        orderTestClient.postOrder(new Order().builder()
                .petId(1L)
                .quantity(2)
                .shipDate("2023-10-01T00:00:00Z")
                .status("placed")
                .complete(true)
                .build());
        log.info("Order created successfully!");
        log.info("Data created successfully!");
    }

    @After
    public void cleanup() {
        log.info("Proceeding with Cleanup");
        log.info("Deleting User");
        orderTestClient.deleteOrderId("1");
        log.info("Deleting Pet");
        petTestClient.deletePet("1");
        log.info("Deleting User");
        userTestClient.deleteUser("testUser");
        log.info("Cleanup Complete");

    }
}
