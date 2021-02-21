package ru.alexalexeev;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class GetAccountTests extends BaseTest{

    @Test
    void getAccountInfoPositiveTest(){
        given()
                .headers("Authorization", token)
                .log()
                .all()
                .when()
                .get("/account/{username}",username)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoNrgativeTest(){
        given()
                .headers("Authorization", token)
                .log()
                .all()
                .when()
                .get("/account/{username}",username)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoPosTest(){
        given()
                .headers("Authorization", token)
                .expect()
                .body(CoreMatchers.containsString(username))
                .body("succses", is(true))
                .when()
                .get("/account/{username}",username)
                .prettyPeek()
                .then()
                .statusCode(200);
    }



}
