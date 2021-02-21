package ru.alexalexeev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostImageJpgTest extends BaseTest{
    String uploadedImageHashCode;
    ClassLoader cLoader = getClass().getClassLoader();
    File jpg = new File(Objects.requireNonNull(cLoader.getResource("./zlo.jpg")).getFile());

    @Test
    @DisplayName("Post image .jpg")
    void uploadFileTest() {
        uploadedImageHashCode = given()
                .headers("Authorization", token)
                .multiPart("image", jpg)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @AfterEach
    void tearDown() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("account/{username}/image/{deleteHash}", username, uploadedImageHashCode)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

}