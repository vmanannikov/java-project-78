[![Actions Status](https://github.com/vmanannikov/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/vmanannikov/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/646be42acbc7897fa303/maintainability)](https://codeclimate.com/github/vmanannikov/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/ea713e0ba86518f1a299/test_coverage)](https://codeclimate.com/github/vmanannikov/java-project-78/test_coverage)

## Валидатор данных
Библиотека для форирования правил проверки данных, можно использовать для валидации данных форм

### Проверямые типы данных
* String
* Number
* Map

Проверяемые условия и примеры их применения указаны ниже

### Использование
Для запуска из проекта
```sh
make validator
```

#### Описание настроек для проверки каждого из типа данных
```sh
import hexlet.code.*;
var v = new Validator();
```
Вызывая соотвествующий метод, формируем тем самым нужную схему проверок

* String - метод string() класса Validator
  ```sh
  var stringSchema = v.string();
  ```
* Number - метод number() класса Validator
  ```sh
  var numberSchema = v.number();
  ```
* Map - метод map() класса Validator
  ```sh
  var mapSchema = v.map();
  ```
#### Добавление условий для каждого в соотвествующую схему
* String
    *  Обязательность
    ```sh
    stringSchema.required();
    ```
    *  Минимальная длина
    ```sh
    stringSchema.minLength();
    ```
    *  Содержит ***текст***
    ```sh
    stringSchema.contains("текст");
    ```
* Number
    *  Обязательность
    ```sh
    numberSchema.required();
    ```
    *  Положительное число
    ```sh
    numberSchema.positive();
    ```
    *  Находится в промежутке ***min*** ***max***
    ```sh
    numberSchema.range(min, max);
    ```
* Map
    *  Обязательность
    ```sh
    mapSchema.required();
    ```
    *  Размер равен ***length***
    ```sh
    mapSchema.sizeof(length);
    ```
## Запуск локально

Клонируем проект

```bash
  git clone https://github.com/vmanannikov/java-project-78
```

Переходим в каталог проекта

```bash
  cd java-project-78/app
```

Собираем приложение

```bash
  make install
```

### Демонстрация работы библиотеки
[![asciicast](https://asciinema.org/a/616569.svg)](https://asciinema.org/a/uIlFgaMWgHR6BCa7Vlta66rag)
