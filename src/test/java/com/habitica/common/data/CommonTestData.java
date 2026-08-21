package com.habitica.common.data;

import com.habitica.common.config.ConfigProvider;

public class CommonTestData {
    public static final String username = ConfigProvider.config.getUsername();
    public static final String userId = ConfigProvider.config.getUserId();
    public static final String password = ConfigProvider.config.getPassword();
    public static final String mail = ConfigProvider.config.getMail();
    public static final String boldUsername = ConfigProvider.config.getBoldUsername();

    public static final String cyrillicUsername = "ТестТестТест";
    public static final String longUsername = "TestTestTestTestTestTestTest";
    public static final String shortPassword = "T";
}
