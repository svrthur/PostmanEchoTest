package your.package.name; // Замените на ваш пакет

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void testPostRequestNegative() {
        String requestBody = "some data"; // Данные, которые мы отправляем

        // Выполняем запрос
        given()
                .baseUri("https://postman-echo.com") // Базовый URI
                .contentType("text/plain; charset=UTF-8") // Указываем тип контента и кодировку
                .body(requestBody) // Добавляем тело запроса
                .when()
                .post("/post") // Выполняем POST-запрос
                .then()
                .statusCode(200) // Проверяем, что статус ответа 200
                .body("invalidField", equalTo(requestBody)); // Проверяем несуществующее поле
    }
