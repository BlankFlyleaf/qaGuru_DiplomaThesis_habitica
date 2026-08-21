package com.habitica.api.models.login;

public record LoginSuccessfulResponseModel(boolean success,
                                           LoginDataItem data,
                                           String appVersion) {
}
