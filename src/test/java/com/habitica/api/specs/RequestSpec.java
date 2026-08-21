package com.habitica.api.specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.habitica.api.allure.CustomAllureListener.withCustomTemplate;
import static io.restassured.RestAssured.with;

public class RequestSpec {
    public static RequestSpecification loginRequest = with()
            .filter(withCustomTemplate())
            .log().all()
            .contentType(ContentType.JSON)
            .basePath("/api/v4");

    public static RequestSpecification taskRequest = with()
            .filter(withCustomTemplate())
            .log().all()
            .header("x-client", "habitica-web")
            .contentType(ContentType.JSON)
            .basePath("/api/v4");
}
