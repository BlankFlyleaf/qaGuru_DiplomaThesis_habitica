package com.habitica.api.apiclients;

import com.habitica.api.models.tasks.TaskBaseBodyModel;
import com.habitica.api.models.tasks.TaskBaseResponseModel;
import io.qameta.allure.Step;

import static com.habitica.api.specs.RequestSpec.taskRequest;
import static com.habitica.api.specs.TaskResponseSpecs.successfulCreateTaskResponseSpec;
import static com.habitica.api.specs.TaskResponseSpecs.successfulDeleteTaskResponseSpec;
import static io.restassured.RestAssured.given;

public class TaskApiClient {

    @Step("Отправляем запрос на создание задачи в систему с базовым набором данных")
    public TaskBaseResponseModel successfulCreateBaseTask(String id, String apiToken, TaskBaseBodyModel data) {
        return given(taskRequest)
                .header("x-api-user", id)
                .header("x-api-key", apiToken)
                .body(data)
                .when()
                .post("/tasks/user")
                .then()
                .spec(successfulCreateTaskResponseSpec)
                .extract().as(TaskBaseResponseModel.class);
    }

    @Step("Отправляем запрос на удаление задачи в систему")
    public TaskBaseResponseModel successfulDeleteTask(String id, String apiToken, String idTask) {
        return given(taskRequest)
                .header("x-api-user", id)
                .header("x-api-key", apiToken)
                .when()
                .delete("/tasks/" + idTask)
                .then()
                .spec(successfulDeleteTaskResponseSpec)
                .extract().as(TaskBaseResponseModel.class);
    }
}
