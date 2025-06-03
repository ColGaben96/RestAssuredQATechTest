package com.visa.qa.restassuredswaggersb.domain.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.visa.qa.restassuredswaggersb.order.client.OrderTestClient;
import com.visa.qa.restassuredswaggersb.pet.client.PetTestClient;
import com.visa.qa.restassuredswaggersb.user.client.UserTestClient;

public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {}

    @Provides
    @Singleton
    public OrderTestClient orderTestClient() {return new OrderTestClient();}
    @Provides
    @Singleton
    public PetTestClient petTestClient() {return new PetTestClient();}
    @Provides
    @Singleton
    public UserTestClient userTestClient() {return new UserTestClient();}
}
