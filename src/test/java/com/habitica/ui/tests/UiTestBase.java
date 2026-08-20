package com.habitica.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.habitica.ui.config.TestConfig;
import com.habitica.ui.data.TestData;
import com.habitica.ui.helpers.Attach;
import com.habitica.ui.pages.LoginPage;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class UiTestBase {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

    LoginPage login = new LoginPage();
    TaskPage task = new TaskPage();
    TestData tD = new TestData();


    @BeforeAll
    static void uiTestConfig() {
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.pageLoadStrategy = config.getPageLoadStrategy();
        Configuration.baseUrl = config.getBaseUrl();

        String selenoidUrl = config.getRemoteUrl();
        if (selenoidUrl != null && !selenoidUrl.isBlank()) {
            Configuration.browserVersion = config.getBrowserVersion();
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeAll
    static void setUpAllure() {
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
