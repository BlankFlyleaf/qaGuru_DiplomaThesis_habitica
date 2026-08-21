package com.habitica.api.apiclients;

import com.habitica.api.models.login.LoginBodyModel;
import com.habitica.api.models.login.LoginErrorResponseModel;
import com.habitica.api.models.login.LoginSuccessfulResponseModel;
import io.qameta.allure.Step;

import static com.habitica.api.specs.LoginResponseSpecs.*;
import static com.habitica.api.specs.RequestSpec.loginRequest;
import static io.restassured.RestAssured.given;

public class LoginApiClient {

    @Step("Отправляем запрос на логин в систему с корректными данными")
    public LoginSuccessfulResponseModel successfulLogin(LoginBodyModel data) {
        return given(loginRequest)
                .body(data)
                .when()
                .post("/user/auth/local/login")
                .then()
                .spec(successfulLoginResponseSpec)
                .extract().as(LoginSuccessfulResponseModel.class);
    }

    @Step("Отправляем некорректный запрос на логин с простым форматированием ошибки")
    public LoginErrorResponseModel simpleErrorLogin(LoginBodyModel data) {
        return given(loginRequest)
                .body(data)
                .when()
                .post("/user/auth/local/login")
                .then()
                .spec(simpleErrorLoginResponse)
                .extract().as(LoginErrorResponseModel.class);
    }

    @Step("Отправляем некорректный запрос на логин с детализированным форматированием ошибки")
    public LoginErrorResponseModel detailedErrorLogin(LoginBodyModel data) {
        return given(loginRequest)
                .body(data)
                .when()
                .post("/user/auth/local/login")
                .then()
                .spec(detailedErrorLoginResponse)
                .extract().as(LoginErrorResponseModel.class);
    }
}
