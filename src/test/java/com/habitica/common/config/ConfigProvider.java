package com.habitica.common.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());
}
