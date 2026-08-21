package com.habitica.common.data;

public enum TaskTags {
    WORK("Работа", "d9a3cae9-1ead-49d8-b467-b608fb048e58"),
    HEALTH("Здоровье и образ жизни", "787c011e-a8f2-41de-b04d-5f5b1bcc1223"),
    EXERCISE("Спортивные упражнения", "b5bcedd7-38db-4ded-bee6-e2967ecaa16c"),
    STUDY("Учеба", "7c216fe3-8223-4cad-ab86-2c3d8d6715a8"),
    TEAMWORK("Работа в команде", "6cc6da27-6086-4495-a60b-3e2ae9ccde4f"),
    HOUSEWORK("Домашние дела", "2daedacf-d7db-4d20-bb1d-ce92714c13a8"),
    CREATIVITY("Творчество", "7f31c165-6edd-444a-8798-fbceb32dbcac");

    private final String displayName;
    private final String tagId;

    TaskTags(String displayName, String tagId) {
        this.displayName = displayName;
        this.tagId = tagId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTagId() {
        return tagId;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
