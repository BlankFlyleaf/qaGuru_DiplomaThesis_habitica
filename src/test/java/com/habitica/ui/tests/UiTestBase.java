package com.habitica.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.habitica.common.config.ConfigProvider;
import com.habitica.ui.data.DynamicUiTestData;
import com.habitica.ui.helpers.Attach;
import com.habitica.ui.pages.LoginPage;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class UiTestBase {

    LoginPage loginUi = new LoginPage();
    TaskPage taskUi = new TaskPage();
    DynamicUiTestData testDataUi = new DynamicUiTestData();

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

            String browserName = ConfigProvider.config.getBrowserName().toLowerCase();
            if (browserName.equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=ru");
                options.setExperimentalOption("prefs", Map.of("intl.accept_languages", "ru,ru-RU"));
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            } else if (browserName.equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--lang=ru");
                options.addPreference("intl.accept_languages", "ru,ru-RU");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            }

            Configuration.browserCapabilities = capabilities;
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void generateRandomVariableForTests() {
        testDataUi.randomUiVariableGeneration();
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (ConfigProvider.config.getRemoteUrl() != null) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}
