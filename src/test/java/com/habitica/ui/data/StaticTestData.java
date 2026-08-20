package com.habitica.ui.data;

import com.habitica.ui.config.ConfigProvider;

public class StaticTestData {
    public static final String username = ConfigProvider.config.getUsername();
    public static final String password = ConfigProvider.config.getPassword();
    public static final String mail = ConfigProvider.config.getMail();
    public static final String boldUsername = ConfigProvider.config.getBoldUsername();

    public static final String cyrillicUsername = "ТестТестТест";
    public static final String longUsername = "TestTestTestTestTestTestTest";
    public static final String shortPassword = "T";
    public static final String alertText = "Ваша электронная почта, имя пользователя или пароль неверны";
    public static final String sizeUsernameError = "Имя пользователя должно быть от 1 до 20 символов.";
    public static final String langUsernameError = "Имя пользователя может содержать только буквы от a-z, цифры 0-9, дефисы или подчеркивания.";
    public static final String sizePasswordError = "Ваш пароль должен содержать как минимум 8 символов.";
}
