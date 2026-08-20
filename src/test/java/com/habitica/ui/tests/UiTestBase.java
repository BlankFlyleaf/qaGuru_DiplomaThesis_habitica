package com.habitica.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.habitica.ui.config.ConfigProvider;
import com.habitica.ui.data.DynamicTestData;
import com.habitica.ui.helpers.Attach;
import com.habitica.ui.pages.LoginPage;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class UiTestBase {

    LoginPage login = new LoginPage();
    TaskPage task = new TaskPage();
    DynamicTestData tD = new DynamicTestData();


    @BeforeAll
    static void uiTestConfig() {
        Configuration.browser = ConfigProvider.config.getBrowserName();
        Configuration.browserVersion = ConfigProvider.config.getBrowserVersion();
        Configuration.browserSize = ConfigProvider.config.getBrowserSize();
        Configuration.pageLoadStrategy = ConfigProvider.config.getPageLoadStrategy();
        Configuration.baseUrl = ConfigProvider.config.getBaseUrl();

        String selenoidUrl = ConfigProvider.config.getRemoteUrl();
        if (selenoidUrl != null && !selenoidUrl.isBlank()) {
            Configuration.browserVersion = ConfigProvider.config.getBrowserVersion();
            Configuration.remote = ConfigProvider.config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void generateRandomVariableForTests() {
        tD.randomVariableGeneration();
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (System.getProperty("SELENOID_URL") != null) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}
