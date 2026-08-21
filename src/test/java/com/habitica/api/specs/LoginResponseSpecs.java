package com.habitica.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static com.habitica.api.data.StaticApiTestData.appVersion;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class LoginResponseSpecs {
    public static ResponseSpecification successfulLoginResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody("success", is(true))
            .expectBody("data.newUser", is(false))
            .expectBody("data.id", notNullValue())
            .expectBody("appVersion", is(appVersion))
            .expectBody("data.username", notNullValue())
            .expectBody(matchesJsonSchemaInClasspath("schemas/login/LoginSuccessfulResponseSchema.json"))
            .build();

    public static ResponseSpecification simpleErrorLoginResponse = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(401)
            .expectBody("success", is(false))
            .expectBody(matchesJsonSchemaInClasspath("schemas/login/LoginSimpleErrorResponseSchema.json"))
            .build();

    public static ResponseSpecification detailedErrorLoginResponse = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody("success", is(false))
            .expectBody(matchesJsonSchemaInClasspath("schemas/login/LoginDetailedErrorResponseSchema.json"))
            .build();
}
