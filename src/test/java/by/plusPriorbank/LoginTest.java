package by.plusPriorbank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    public void test1() {
        String body = "{\n" +
                "    \"user\": {\n" +
                "        \"email\": \"dcdc@dfd.fd\",\n" +
                "        \"password\": \"dcsdcs\"\n" +
                "    }\n" +
                "}";
        String url = "https://plus.priorbank.by/authorization/login.json";
        given()
                .body(body)
                .headers("Content-Type", "application/json")
                .headers("Cookie", "user_token=1111568754; _ga=GA1.1.1608432738.1731358403; session_time_popup=1731925228375; _ga_G7RP2LFLN8=GS1.1.1731925228.5.0.1731925228.0.0.0; _session_id=FYtZg8rL%2FnWyNlukieee2BnJMPOCIWG1GdafbWMdYQgghfXnHwBeBaxCBYZgqwnHT8AkLiBer50OhOkQf1%2FJARD7rOAJhJcwKFO6R%2FJ3LlNnV6Mz%2BSRC2Yvcy%2F9w1ToDGg9mLRnm%2Fr7sRkY4jtX5kS0HD6s936w3IR1JTMQpK5eZBQwUGBo%2B2TqdjQ0%2Bm48r8tb%2BgqOmGfYg3Vx%2FwAi3Zkw3gSiz%2Fa6r5qxlPgQLT0ruAg73vu6f1uzEFc5ngqC6X%2BrhpikgQLE0gNKil91PG%2BBkAHxPP5y%2Flf5ap%2F67UF%2Br5K7kF%2BAJ7HR7z4OYo08WzMQEzI8N1nZQaHa2Hk7x--6wvZTJGPA4EJAVPM--YT27ehJRP5FgHN9P4V5G%2FQ%3D%3D")
                .headers("X-CSRF-Token", "Ldo09LuP+z/V6kuNqAcJNMCbNBlM4Afm+L38t7WCpj6vkYOb3xPlSrjwxLI4lWNxsWxiDDAS/rzXefcIVkJoxw")
        .when()
                .post(url)
        .then()
                .log().all()
                .statusCode(422);
                //.body("errors.global", equalTo("Ошибка авторизации, неверный логин/пароль или пользователь заблокирован"));
    }
}
