<div align="center">

<img src="media/habitica-logo.png" width="100" alt="Habitica Logo"/>

# ⚔️ Habitica — Автоматизация тестирования

> *Превращай баги в монстров. Убивай их тестами.*

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)
[![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Selenide](https://img.shields.io/badge/Selenide-7.16-00B4D8?style=for-the-badge&logo=selenium&logoColor=white)](https://selenide.org/)
[![REST Assured](https://img.shields.io/badge/REST--Assured-6.0-4CAF50?style=for-the-badge&logo=postman&logoColor=white)](https://rest-assured.io/)

[![Allure](https://img.shields.io/badge/Allure_Report-2.34-orange?style=for-the-badge&logo=databricks&logoColor=white)](https://allurereport.org/)
[![Allure TestOps](https://img.shields.io/badge/Allure_TestOps-cloud-orange?style=for-the-badge&logo=databricks&logoColor=white)](https://qameta.io/)
[![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-D24939?style=for-the-badge&logo=jenkins&logoColor=white)](https://www.jenkins.io/)
[![Selenoid](https://img.shields.io/badge/Selenoid-remote-5C6BC0?style=for-the-badge&logo=googlechrome&logoColor=white)](https://aerokube.com/selenoid/)
[![Jira](https://img.shields.io/badge/Jira-integration-0052CC?style=for-the-badge&logo=jira&logoColor=white)](https://jira.autotests.cloud/)
[![Telegram](https://img.shields.io/badge/Telegram-notifications-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/)

</div>

---

## 🗺️ О проекте

**[Habitica](https://habitica.com)** — приложение для управления привычками и задачами в формате RPG-игры. Пользователь создаёт персонажа, выполняет реальные задачи и получает игровые награды.

Этот репозиторий содержит дипломный проект по автоматизации тестирования Habitica, выполненный в рамках курса **QA.GURU**. Проект покрывает **API** и **UI** тесты с интеграцией в CI/CD.

---

## 🧪 Тестовое покрытие

### ⚔️ Feature: Авторизация API

| # | Story | Тест-кейс | Тип |
|---|---|---|---|
| 1 | Успешный вход | Успешная авторизация с учётной записью пользователя | ✅ Позитивный |
| 2 | Успешный вход | Успешная авторизация с электронной почтой пользователя | ✅ Позитивный |
| 3 | Валидация инпутов | Проверка ошибки при нарушении регистра в имени пользователя | ❌ Негативный |
| 4 | Валидация инпутов | Проверка валидации пустого значения в имени пользователя | ❌ Негативный |
| 5 | Валидация инпутов | Проверка валидации null значения в имени пользователя | ❌ Негативный |
| 6 | Валидация инпутов | Проверка валидации превышения символов в имени пользователя | ❌ Негативный |
| 7 | Валидация инпутов | Проверка валидации кириллических символов в имени пользователя | ❌ Негативный |
| 8 | Валидация инпутов | Проверка валидации пустого значения пароля | ❌ Негативный |
| 9 | Валидация инпутов | Проверка валидации null значения пароля | ❌ Негативный |
| 10 | Валидация инпутов | Проверка валидации длины пароля | ❌ Негативный |

### 🗡️ Feature: Задачи API

| # | Story | Тест-кейс | Тип |
|---|---|---|---|
| 1 | Создание задачи | Успешное создание Привычки (Habit) | ✅ Позитивный |
| 2 | Создание задачи | Успешное создание Ежедневного дела (Daily) | ✅ Позитивный |
| 3 | Создание задачи | Успешное создание Задачи (ToDo) | ✅ Позитивный |
| 4 | Удаление задачи | Успешное удаление Привычки (Habit) | ✅ Позитивный |
| 5 | Удаление задачи | Успешное удаление Ежедневного дела (Daily) | ✅ Позитивный |
| 6 | Удаление задачи | Успешное удаление Задачи (ToDo) | ✅ Позитивный |

### 🛡️ Feature: Авторизация UI

| # | Story | Тест-кейс | Тип |
|---|---|---|---|
| 1 | Успешный вход | Успешная авторизация с учётной записью пользователя | ✅ Позитивный |
| 2 | Успешный вход | Успешная авторизация с электронной почтой пользователя | ✅ Позитивный |
| 3 | Неуспешный вход | Проверка появления алерта при нарушении регистра | ❌ Негативный |
| 4 | Доступность кнопок | Проверка доступности кнопок на странице логина | ✅ Позитивный |
| 5 | Валидация инпутов | Проверка валидации пустого значения в пользовательском имени | ❌ Негативный |
| 6 | Валидация инпутов | Проверка валидации превышения символов в пользовательском имени | ❌ Негативный |
| 7 | Валидация инпутов | Проверка валидации кириллических символов в пользовательском имени | ❌ Негативный |
| 8 | Валидация инпутов | Проверка валидации длины пароля | ❌ Негативный |

### 🏹 Feature: Задачи UI

| # | Story | Тест-кейс | Тип |
|---|---|---|---|
| 1 | Создание задачи | Создание Привычки с заполнением всех полей | ✅ Позитивный |
| 2 | Создание задачи | Создание Ежедневного дела с заполнением всех полей | ✅ Позитивный |
| 3 | Создание задачи | Создание Задачи (ToDo) с заполнением всех полей | ✅ Позитивный |
| 4 | Удаление задачи | Удаление Привычки (Habit) | ✅ Позитивный |
| 5 | Удаление задачи | Удаление Ежедневного дела (Daily) | ✅ Позитивный |
| 6 | Удаление задачи | Удаление Задачи (ToDo) | ✅ Позитивный |

---

## 🚀 Запуск тестов

### Локально

```bash
# Все тесты
./gradlew test

# По тегу
./gradlew test -DincludeTags="Smoke"
./gradlew test -DincludeTags="Regression"
./gradlew test -DincludeTags="ApiTests"
./gradlew test -DincludeTags="UiTests"

# Комбинированный тег
./gradlew test -DincludeTags="Smoke & ApiTests"
```

### Через Selenoid (remote)

```bash
./gradlew test \
  -Denv=remote \
  -DbrowserName=chrome \
  -DbrowserVersion=128.0 \
  -DremoteUrl=http://<selenoid-host>:4444/wd/hub
```

### Параметры конфигурации

| Параметр | По умолчанию | Описание |
|---|---|---|
| `browserName` | `chrome` | Браузер |
| `browserVersion` | `128.0` | Версия браузера |
| `browserSize` | `1920x1080` | Размер окна |
| `baseUrl` | `https://habitica.com` | Базовый URL |
| `remoteUrl` | — | URL Selenoid |
| `env` | `local` | Окружение (local / remote) |

---

## 🔧 CI/CD — Jenkins

Сборка настроена как **Freestyle Job** с параметрами:

<div align="center">
  <a href="media/Jenkins-1.png">
    <img src="media/Jenkins-1.png" alt="Jenkins Job" width="70%"/>
  </a>
</div>

| Параметр | Тип | Значения |
|---|---|---|
| `BROWSER` | Choice | Chrome, Firefox |
| `BROWSER_VERSION` | Active Choices Reactive | Chrome: 148, 149 · Firefox: 150, 151 |
| `ENVIRONMENT` | Choice | Prod |
| `TEST_SUITE` | Choice | Api & UI — Regression, Api & UI — Smoke, API — Regression, API — Smoke, UI — Regression, UI — Smoke |

В зависимости от выбранного `TEST_SUITE` запускаются соответствующие наборы тестов.

---

## 📊 Отчётность

### Allure Report

```bash
./gradlew allureReport
./gradlew allureServe
```

<div align="center">
  <a href="media/Allure-1.png">
    <img src="media/Allure-1.png" alt="Allure Dashboard" width="70%"/>
  </a>
</div>

Отчёт включает:

- Dashboard с общей статистикой
- Дерево тест-кейсов по Feature / Story
- Скриншоты последнего состояния браузера
- Видеозаписи из Selenoid
- Логи консоли браузера
- Тела HTTP-запросов и ответов (REST Assured) с кастомным форматированием

#### Примеры других страниц

<div align="center">
  <a href="media/Allure-2.png">
    <img src="media/Allure-2.png" alt="Allure Suites" width="49%"/>
  </a>
  <a href="media/Allure-3.png">
    <img src="media/Allure-3.png" alt="Allure Test Detail" width="49%"/>
  </a>
</div>

#### Пример видео-прогона теста

<div align="center">
  <img src="media/gif-1.gif" alt="Allure Report Demo" width="70%"/>
</div>

### Allure TestOps

Все запуски автоматически попадают в **Allure TestOps**. Каждый прогон из Jenkins создаёт Launch с полным набором результатов.

<div align="center">
  <a href="media/TestOps-1.png">
    <img src="media/TestOps-1.png" alt="Allure TestOps Launches" width="70%"/>
  </a>
</div>

Для удобства настроены тест-планы — можно запустить нужный набор тестов прямо из TestOps:

<div align="center">
  <a href="media/TestOps-2.png">
    <img src="media/TestOps-2.png" alt="Allure TestOps Test Plans" width="49%"/>
  </a>
  <a href="media/TestOps-3.png">
    <img src="media/TestOps-3.png" alt="Allure TestOps Test Cases" width="49%"/>
  </a>
</div>

### 🔗 Jira

Настроена интеграция с Jira для отслеживания дефектов и связи тест-кейсов с задачами:

<div align="center">
  <a href="media/Jira-1.png">
    <img src="media/Jira-1.png" alt="Jira Integration" width="70%"/>
  </a>
</div>

---

## 📨 Telegram Notifications

После каждого прогона в Jenkins автоматически отправляется уведомление в Telegram-чат с результатами сборки.

Уведомление включает:

- Статус сборки (успех / провал)
- Количество пройденных, упавших и пропущенных тестов
- Ссылку на Allure-отчёт
- Ссылку на сборку в Jenkins

---

<div align="center">

*⚔️ Квест пройден. Баги побеждены. 🏆*

[@BlankFlyleaf](https://github.com/BlankFlyleaf)

</div>
