package com.habitica.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public final SelenideElement loginButton = $("a[href='/login']");
    public final SelenideElement usernameForm = $("#usernameInput");
    public final SelenideElement passwordForm = $("#passwordInput");
    public final SelenideElement submitButton = $("[type='submit']");
    public final SelenideElement googleButton = $$(".social-button").findBy(text("Продолжить через Google"));
    public final SelenideElement appleButton = $$(".social-button").findBy(text("Продолжить через Apple"));
    public final SelenideElement forgotPasswordButton = $("a.forgot-password");
    public final SelenideElement registerButton = $("a[href='/register']");
    public final SelenideElement alertCloud = $(".notification.error");
    public final SelenideElement validationError = $(".input-error");
    private final SelenideElement acceptAllCookieButton = $("#privacy-banner").$(".btn-primary");
    private final SelenideElement cookiePanel = $("#privacy-banner");

    @Step("Открываем страницу главную страницу")
    public LoginPage openMainPage() {
        open("/static/home");
        return this;
    }

    @Step("Открываем страницу Логина")
    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    @Step("Нажать кнопку 'Принять все файлы cookie'")
    public LoginPage clickAcceptAllCookie() {
        acceptAllCookieButton
                .click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Вход' на приветственной странице")
    public LoginPage clickLoginButton() {
        loginButton
                .click();
        return this;
    }

    @Step("Заполняем поле 'Имя пользователя или Электронный адрес (с учетом регистра)' значением: {username}")
    public LoginPage setUsernameValue(String username) {
        usernameForm
                .setValue(username);
        return this;
    }

    @Step("Заполняем поле 'Пароль'")
    public LoginPage setPasswordValue(String password) {
        passwordForm
                .setValue(password);
        return this;
    }

    @Step("Нажимаем на кнопку 'Вход' на форме заполнения данных пользователя")
    public LoginPage clickSubmitButton() {
        submitButton
                .click();
        return this;
    }

    @Step("Проверяем доступность кнопки 'Продолжить через Google'")
    public LoginPage checkGoogleButton() {
        googleButton
                .shouldBe(enabled)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверяем доступность кнопки 'Продолжить через Apple'")
    public LoginPage checkAppleButton() {
        appleButton
                .shouldBe(enabled)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверяем доступность кнопки 'Забыли пароль?'")
    public LoginPage checkRegisterButton() {
        registerButton
                .shouldBe(enabled)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверяем доступность кнопки 'Нет учётной записи в Habitica? Зарегистрируйтесь'")
    public LoginPage checkForgotPasswordButton() {
        forgotPasswordButton
                .shouldBe(enabled)
                .shouldBe(clickable);
        return this;
    }

    @Step("Проверяем появление алерта при некорректном логине с текстом: {alertText}")
    public LoginPage checkAlert(String alertText) {
        alertCloud
                .shouldBe(visible)
                .shouldHave(text(alertText));
        return this;
    }

    @Step("Проверяем валидацию инпута с ошибкой: {errorText}")
    public LoginPage checkValidationError(String errorText) {
        validationError
                .shouldBe(visible)
                .shouldHave(text(errorText));
        return this;
    }

    @Step("Проверяем блокировку кнопки сабмита")
    public LoginPage checkBlockedSumbitButton() {
        submitButton
                .shouldNotBe(enabled)
                .shouldNotBe(clickable);
        return this;
    }

    @Step("Проверяем, что панель cookie скрылась")
    public LoginPage checkCookiePanel() {
        cookiePanel
                .shouldNotBe(visible);
        return this;
    }
}