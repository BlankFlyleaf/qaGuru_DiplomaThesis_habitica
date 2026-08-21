package com.habitica.api.tests;

import com.habitica.api.apiclients.ApiClient;
import com.habitica.api.data.DynamicApiTestData;
import com.habitica.common.config.ConfigProvider;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class ApiTestBase {
    protected ApiClient api = new ApiClient();
    DynamicApiTestData testDataApi = new DynamicApiTestData();


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = ConfigProvider.config.getBaseUrl();
    }

    @BeforeEach
    void generateRandomVariableForTests() {
        testDataApi.randomApiVariableGeneration();
    }
}
