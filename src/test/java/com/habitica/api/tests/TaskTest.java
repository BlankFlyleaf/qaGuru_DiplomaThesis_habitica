package com.habitica.api.tests;

import com.habitica.api.models.login.LoginBodyModel;
import com.habitica.api.models.login.LoginSuccessfulResponseModel;
import com.habitica.api.models.tasks.TaskBaseBodyModel;
import com.habitica.api.models.tasks.TaskBaseResponseModel;
import com.habitica.common.data.TaskType;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static com.habitica.common.data.CommonTestData.password;
import static com.habitica.common.data.CommonTestData.username;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


@Owner("BlankFlyleaf")
@Feature("Задачи API")
public class TaskTest extends ApiTestBase {

    @EnumSource(TaskType.class)
    @ParameterizedTest
    @Story("Создание задачи")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Успешное создание задачи")
    @Tags({@Tag("ApiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void successfulCreateTaskApiTest(TaskType taskType) {
        LoginBodyModel loginData = new LoginBodyModel(username, password);

        LoginSuccessfulResponseModel loginResponse =
                api.loginApi.successfulLogin(loginData);

        String idUser = loginResponse.data().id();
        String apiToken = loginResponse.data().apiToken();

        TaskBaseBodyModel taskData = new TaskBaseBodyModel(
                taskType.cssType,
                testDataApi.titleRandom,
                testDataApi.noteRandom,
                testDataApi.difficultyRandom.getPriority(),
                List.of(testDataApi.firstTagRandom.getTagId(),
                        testDataApi.secondTagRandom.getTagId())
        );

        TaskBaseResponseModel taskResponse =
                api.taskApi.successfulCreateBaseTask(idUser, apiToken, taskData);

        step("Проверяем атрибуты ответа успешного запроса на создание задачи {taskType.cssType}", () -> {
            assertThat(taskResponse.data().userId()).isEqualTo(idUser);
            assertThat(taskResponse.data().type()).isEqualTo(taskType.cssType);
            assertThat(taskResponse.data().text()).isEqualTo(testDataApi.titleRandom);
            assertThat(taskResponse.data().notes()).isEqualTo(testDataApi.noteRandom);
            assertThat(taskResponse.data().priority()).isEqualTo(testDataApi.difficultyRandom.getPriority());
            assertThat(taskResponse.data().tags().get(0)).isEqualTo(testDataApi.firstTagRandom.getTagId());
            assertThat(taskResponse.data().tags().get(1)).isEqualTo(testDataApi.secondTagRandom.getTagId());
        });
    }

    @EnumSource(TaskType.class)
    @ParameterizedTest
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Успешное удаление задачи")
    @Tags({@Tag("ApiTests"), @Tag("Regression")})
    public void successfulDeleteTaskApiTest(TaskType taskType) {
        LoginBodyModel loginData = new LoginBodyModel(username, password);

        LoginSuccessfulResponseModel loginResponse =
                api.loginApi.successfulLogin(loginData);

        String idUser = loginResponse.data().id();
        String apiToken = loginResponse.data().apiToken();

        TaskBaseBodyModel taskData = new TaskBaseBodyModel(
                taskType.cssType,
                testDataApi.titleRandom,
                testDataApi.noteRandom,
                testDataApi.difficultyRandom.getPriority(),
                List.of(testDataApi.firstTagRandom.getTagId(),
                        testDataApi.secondTagRandom.getTagId())
        );

        TaskBaseResponseModel taskResponse =
                api.taskApi.successfulCreateBaseTask(idUser, apiToken, taskData);

        String idTask = taskResponse.data().id();

        api.taskApi.successfulDeleteTask(idUser, apiToken, idTask);
    }
}
