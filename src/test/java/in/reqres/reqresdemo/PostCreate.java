package in.reqres.reqresdemo;

import in.reqres.model.StudentPojo;
import in.reqres.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreate extends Testbase {
    @Test
    public void postcreated() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("morpheus");
        studentPojo.setJob("leader");
        Response response = given()
                .header("Connection", "keep-alive")
                .body(studentPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void postloginsuccessul() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("eve.holt@reqres.in");
        studentPojo.setPassword("cityslicka");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}