package com.habitica.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static com.habitica.api.data.StaticApiTestData.appVersion;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class TaskResponseSpecs {
    public static ResponseSpecification successfulCreateTaskResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(201)
            .expectBody("success", is(true))
            .expectBody("appVersion", is(appVersion))
            .build();

    public static ResponseSpecification successfulDeleteTaskResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody("success", is(true))
            .expectBody("appVersion", is(appVersion))
            .expectBody(matchesJsonSchemaInClasspath("schemas/tasks/TaskSuccessfulDeleteResponseSchema.json"))
            .build();
}
