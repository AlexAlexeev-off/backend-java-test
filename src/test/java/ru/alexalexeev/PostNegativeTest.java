package ru.alexalexeev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostNegativeTest extends BaseTest{
    ClassLoader cLoader = getClass().getClassLoader();
    File jpg10mb = new File(Objects.requireNonNull(cLoader.getResource("./10mb.jpg")).getFile());
    File video = new File(Objects.requireNonNull(cLoader.getResource("./video.mp4")).getFile());
    File text = new File(Objects.requireNonNull(cLoader.getResource("./text.txt")).getFile());
    File music = new File(Objects.requireNonNull(cLoader.getResource("./music.mp3")).getFile());

    @Test
    @DisplayName("Post image .jpg 10mb")
    void upload10mbTest() {
        given()
                .headers("Authorization", token)
                .multiPart("image", jpg10mb)
                .expect()
                .body("success", is(false))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(400);
    }
    @Test
    @DisplayName("Post video")
    void uploadVideoTest() {
        given()
                .headers("Authorization", token)
                .multiPart("image", video)
                .expect()
                .body("success", is(false))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(400);
    }
    @Test
    @DisplayName("Post text")
    void uploadTextTest() {
        given()
                .headers("Authorization", token)
                .multiPart("image", text)
                .expect()
                .body("success", is(false))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(400);
    }
    @Test
    @DisplayName("Post music")
    void uploadMusicTest() {
        given()
                .headers("Authorization", token)
                .multiPart("image", music)
                .expect()
                .body("success", is(false))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(400);
    }
}