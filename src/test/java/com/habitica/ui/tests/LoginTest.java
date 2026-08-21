package com.habitica.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.habitica.common.data.CommonTestData.*;
import static com.habitica.ui.data.StaticUiTestData.*;

@Owner("BlankFlyleaf")
@Feature("Авторизация UI")
public class LoginTest extends UiTestBase {

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с учетной записью пользователя")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulUsernameLoginTest() {
        loginUi
                .openMainPage()
                .clickAcceptAllCookie()
                .checkCookiePanel()
                .clickLoginButton()
                .setUsernameValue(username)
                .setPasswordValue(password)
                .clickSubmitButton();
        taskUi
                .checkAvatar()
                .checkCharacterName(username)
                .checkCreateTaskButton();
    }

    @Test
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешная авторизация с учетной электронной почтой пользователя")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulMailLoginTest() {
        loginUi
                .openMainPage()
                .clickAcceptAllCookie()
                .checkCookiePanel()
                .clickLoginButton()
                .setUsernameValue(mail)
                .setPasswordValue(password)
                .clickSubmitButton();
        taskUi
                .checkAvatar()
                .checkCharacterName(username)
                .checkCreateTaskButton();
    }

    @Test
    @Story("Неуспешный вход")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка появления алерта при нарушении регистра")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void wrongRegisterLoginTest() {
        loginUi
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(boldUsername)
                .setPasswordValue(password)
                .clickSubmitButton()
                .checkAlert(alertText);
    }

    @Test
    @Story("Доступность кнопок")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка доступности кнопок на странице логина")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void checkButtonOnLoginPageTest() {
        loginUi
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
        loginUi
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue("")
                .setPasswordValue(password)
                .checkBlockedSubmitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации превышения символов в пользовательском имени")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void sizeUsernameValidationTest() {
        loginUi
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(longUsername)
                .checkValidationError(sizeUsernameError)
                .checkBlockedSubmitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации кириллических символов в пользовательском имени")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void languageUsernameValidationTest() {
        loginUi
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(cyrillicUsername)
                .checkValidationError(langUsernameError)
                .checkBlockedSubmitButton();
    }

    @Test
    @Story("Валидация инпутов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка валидации длины пароля")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void sizePasswordValidationTest() {
        loginUi
                .openMainPage()
                .clickLoginButton()
                .setUsernameValue(username)
                .setPasswordValue(shortPassword)
                .checkValidationError(sizePasswordError)
                .checkBlockedSubmitButton();
    }
}
