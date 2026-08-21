package com.habitica.api.tests;

import com.habitica.api.models.login.LoginBodyModel;
import com.habitica.api.models.login.LoginErrorResponseModel;
import com.habitica.api.models.login.LoginSuccessfulResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.habitica.api.data.StaticApiTestData.*;
import static com.habitica.common.data.CommonTestData.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("BlankFlyleaf")
@Feature("Авторизация API")
public class LoginTest extends ApiTestBase {

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с учетной записью пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulLoginApiTest() {
        LoginBodyModel data = new LoginBodyModel(username, password);

        LoginSuccessfulResponseModel loginResponse =
                api.loginApi.successfulLogin(data);

        step("Проверяем атрибуты ответа успешного запроса на логин", () -> {
            assertThat(loginResponse.data().id()).isEqualTo(userId);
            assertThat(loginResponse.data().username()).isEqualTo(username);
            assertThat(loginResponse.data().newUser()).isEqualTo(false);
        });
    }

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с электронной почтой пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulMailLoginApiTest() {
        LoginBodyModel data = new LoginBodyModel(mail, password);

        LoginSuccessfulResponseModel loginResponse =
                api.loginApi.successfulLogin(data);

        step("Проверяем атрибуты ответа успешного запроса на логин", () -> {
            assertThat(loginResponse.data().id()).isEqualTo(userId);
            assertThat(loginResponse.data().username()).isEqualTo(username);
            assertThat(loginResponse.data().newUser()).isEqualTo(false);
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка ошибки при нарушении регистра в имени пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void wrongRegisterLoginApiTest() {
        LoginBodyModel data = new LoginBodyModel(boldUsername, password);

        LoginErrorResponseModel loginResponse =
                api.loginApi.simpleErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(authError);
            assertThat(loginResponse.message()).isEqualTo(incorrectLoginMessage);
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации пустого значения в имени пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void emptyUsernameValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel("", password);

        LoginErrorResponseModel loginResponse =
                api.loginApi.detailedErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(badRequestError);
            assertThat(loginResponse.message()).isEqualTo(invalidParametersMessage);
            assertThat(loginResponse.errors().get(0).message()).isEqualTo(missingUserParamDetailedMessage);
            assertThat(loginResponse.errors().get(0).param()).isEqualTo(usernameParam);
            assertThat(loginResponse.errors().get(0).value()).isEqualTo("");
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации null значения в имени пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void nullUsernameValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(null, password);

        LoginErrorResponseModel loginResponse =
                api.loginApi.detailedErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(badRequestError);
            assertThat(loginResponse.message()).isEqualTo(invalidParametersMessage);
            assertThat(loginResponse.errors().get(0).message()).isEqualTo(missingUserParamDetailedMessage);
            assertThat(loginResponse.errors().get(0).param()).isEqualTo(usernameParam);
            assertThat(loginResponse.errors().get(0).value()).isNull();
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации превышения символов в имени пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void sizeUsernameValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(longUsername, password);

        LoginErrorResponseModel loginResponse =
                api.loginApi.simpleErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(authError);
            assertThat(loginResponse.message()).isEqualTo(incorrectLoginMessage);
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации кириллических символов в имени пользователя")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void languageUsernameValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(cyrillicUsername, password);

        LoginErrorResponseModel loginResponse =
                api.loginApi.simpleErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(authError);
            assertThat(loginResponse.message()).isEqualTo(incorrectLoginMessage);
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации пустого значения пароля")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void emptyPasswordValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(username, "");

        LoginErrorResponseModel loginResponse =
                api.loginApi.detailedErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(badRequestError);
            assertThat(loginResponse.message()).isEqualTo(invalidParametersMessage);
            assertThat(loginResponse.errors().get(0).message()).isEqualTo(missingPasswordParamDetailedMessage);
            assertThat(loginResponse.errors().get(0).param()).isEqualTo(passwordParam);
            assertThat(loginResponse.errors().get(0).value()).isEqualTo("");
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации null значения пароля")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void nullPasswordValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(username, null);

        LoginErrorResponseModel loginResponse =
                api.loginApi.detailedErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(badRequestError);
            assertThat(loginResponse.message()).isEqualTo(invalidParametersMessage);
            assertThat(loginResponse.errors().get(0).message()).isEqualTo(missingPasswordParamDetailedMessage);
            assertThat(loginResponse.errors().get(0).param()).isEqualTo(passwordParam);
            assertThat(loginResponse.errors().get(0).value()).isNull();
        });
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации длины пароля")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void sizePasswordValidationApiTest() {
        LoginBodyModel data = new LoginBodyModel(username, shortPassword);

        LoginErrorResponseModel loginResponse =
                api.loginApi.simpleErrorLogin(data);

        step("Проверяем атрибуты ответа неуспешного запроса на логин", () -> {
            assertThat(loginResponse.error()).isEqualTo(authError);
            assertThat(loginResponse.message()).isEqualTo(incorrectLoginMessage);
        });
    }
}
