package in.reqres.reqresdemo;

import in.reqres.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DelateUser extends Testbase {
    @Test
    public void delateuser(){
        Response response=given()
                .pathParam("id", 2)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        System.out.println("Data is delated");
        response.prettyPrint();
    }
}
