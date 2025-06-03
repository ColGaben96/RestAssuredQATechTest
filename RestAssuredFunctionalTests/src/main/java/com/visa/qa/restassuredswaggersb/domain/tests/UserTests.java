package com.visa.qa.restassuredswaggersb.domain.tests;

import com.google.inject.Inject;
import com.visa.qa.restassuredswaggersb.domain.config.TestModule;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;

@Guice(modules = TestModule.class)
public class UserTests extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(UserTests.class);
}
