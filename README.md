# Веб-сервис для загрузки и просмотра изображений

## Описание проекта

Данный проект представляет собой веб-сервис для загрузки изображений в базу данных и их просмотра. Проект разработан в соответствии с техническим заданием для проверки знаний соискателя.

## Технологический стек

- **База данных**: PostgreSQL
- **Фреймворк**: Spring MVC
- **JPA**: Используется для взаимодействия с базой данных
- **Безопасность**: Spring Security
- **Сервер**: Tomcat 9
- **Язык программирования**: Java 17
- **Система сборки**: Maven

## Роли пользователей

1. **Администратор**
   - Может загружать свои изображения.
   - Может удалять любые изображения.
   - Может просматривать изображения всех пользователей.

2. **Пользователь**
   - Может загружать свои изображения.
   - Может удалять свои изображения.
   - Может просматривать изображения всех пользователей.

## Функциональные возможности

### Пользовательский интерфейс

- **Страница входа**
  - Вход в систему для администраторов и пользователей.

- **Страница регистрации**
  - Регистрация новых пользователей.

- **Страница загрузки изображений**
  - Пользователь может загружать свои изображения.
  - Администратор может загружать свои изображения.

- **Страница просмотра всех изображений**
  - Вывод всех изображений от новых к старым.
  - Под каждой записью указан автор и время публикации.
  - Изображения выводятся в виде вертикального списка.
  - Пагинация: 10 изображений на страницу.

- **Страница просмотра своих изображений**
  - Просмотр своих загруженных изображений.
  - Возможность удаления своих изображений.

### Реализовано

- **Страница входа**
- **Страница регистрации**
- **Страница просмотра всех изображений**
- **Страница просмотра своих изображений и загрузки изображений**
- **Все изображения выводятся от новых к старым**
- **Под каждой записью указан автор и время публикации**
- **Возможность переключения между страницами (пачками) изображений**

## Техническое задание

### Формулировка

Необходимо реализовать веб-сервис с возможностью загружать изображения в базу данных и их просмотром.

### Требования к frontend части

Необходимо реализовать 4 веб-страницы:

1. Страница входа.
2. Страницу регистрации.
3. Страница загрузки изображений.
4. Страница просмотра всех изображений.
5. Страница просмотра своих изображений. 

Требования к вкладке просмотра изображений:

- Должны выводиться все изображения от новых к старым.
- Должен быть указан логин автора изображения.
- Изображения должны выводиться в виде вертикального списка, с указанием кол-ва изображений на странице. (10 изображений на страницу)
- Возможность переключения между страницами (пачками) изображений.

### Требования к Backend части

- Использовать Spring MVC.
- Реализовать систему авторизации и аутентификации с использованием Spring Security.
- Реализовать взаимодействие с сущностями БД с помощью JPA/Hibernate.
- База данных PostgreSQL.
- Приложение должно использовать Java 17 и запускаться на Tomcat 9.
- Для сборки проекта использовать Maven.
- Система должна содержать 2 роли: Администратор и пользователь.
- Пользователь может загружать/удалять свои изображения и смотреть изображения других пользователей.
- Администратор может удалять любые изображения и загружать свои.

### Результат

Результат предоставляется в формате исходного кода проекта и скомпилированного WAR архива.

## Инструкции по сборке и запуску

1. **Клонируйте репозиторий:**

   ```bash
   git clone <https://github.com/Tufuteca/UploadImages>
