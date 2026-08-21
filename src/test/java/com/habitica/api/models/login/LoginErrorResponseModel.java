package com.habitica.api.models.login;

import java.util.List;

public record LoginErrorResponseModel(String success,
                                      String error,
                                      String message,
                                      List<LoginErrorItem> errors) {
}
