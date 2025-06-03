package com.visa.qa.restassuredswaggersb.domain.config;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ClientModule());
    }
}
