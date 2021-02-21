package ru.alexalexeev;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostImageJpg10mbBase64Test extends BaseTest{
    String encodedImage;

    @BeforeEach
    void setUp(){
        byte[] fileContent = getFileContentInBase64();
        encodedImage = Base64.getEncoder().encodeToString(fileContent);
    }

    @Test
    @DisplayName("Post image .jpg 10mb in code base64")
    void uploadFileTest() {
        given()
                .headers("Authorization", token)
                .multiPart("image", encodedImage)
                .expect()
                .body("success", is(false))
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(400);
    }

    private byte[] getFileContentInBase64() {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(Objects.requireNonNull(classLoader.getResource("./10mb.jpg")).getFile());
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}