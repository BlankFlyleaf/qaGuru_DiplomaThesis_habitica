package com.habitica.ui.tests;

import com.habitica.ui.data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("BlankFlyleaf")
@Feature("Авторизация")
public class LoginTest extends UiTestBase {

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с учетной записью пользователя")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulUsernameLoginTest() {
        login
                .openMainPage()
                .clickAcceptAllCookie()
                .checkCookiePanel()
                .clickLoginButton()
                .setUsernameValue(TestData.username)
                .setPasswordValue(TestData.password)
                .clickSubmitButton();
        task
                .checkAvatar()
                .checkCharacterName(TestData.username)
                .checkCreateTaskButton();
    }

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с учетной электронной почтой пользователя")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulMailLoginTest() {
        login
                .openMainPage()
                .clickAcceptAllCookie()
                .checkCookiePanel()
                .clickLoginButton()
                .setUsernameValue(TestData.mail)
                .setPasswordValue(TestData.password)
                .clickSubmitButton();
        task
                .checkAvatar()
                .checkCharacterName(TestData.username)
                .checkCreateTaskButton();
    }

    @Test
    @Story("Неуспешный вход")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка появления алерта при нарушении регистра")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void wrongRegisterLoginTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(TestData.boldUsername)
                .setPasswordValue(TestData.password)
                .clickSubmitButton()
                .checkAlert(TestData.alertText);
    }

    @Test
    @Story("Доступность кнопок")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка доступности кнопок на странице логина")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void checkButtonOnLoginPageTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .checkGoogleButton()
                .checkAppleButton()
                .checkForgotPasswordButton()
                .checkRegisterButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации пустого значения в пользовательском имени")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void emptyUsernameValidationTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue("")
                .setPasswordValue(TestData.password)
                .checkBlockedSumbitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации превышения символов в пользовательском имени")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void sizeUsernameValidationTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(TestData.longUsername)
                .checkValidationError(TestData.sizeUsernameError)
                .checkBlockedSumbitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации кириллических символов в пользовательском имени")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void languageUsernameValidationTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(TestData.cyrillicUsername)
                .checkValidationError(TestData.langUsernameError)
                .checkBlockedSumbitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации длины пароля")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void sizePasswordValidationTest() {
        login
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(TestData.username)
                .setPasswordValue(TestData.shortPassword)
                .checkValidationError(TestData.sizePasswordError)
                .checkBlockedSumbitButton();
    }
}
