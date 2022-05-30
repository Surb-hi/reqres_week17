package in.reqres.reqresdemo;

import in.reqres.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetListUsers extends Testbase {

    @Test
    //get all data
    public void test001() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
        //page=2
        int page = response.then().extract().path("page");
        System.out.println("Page value is : " + page);

        //per_page = 6
        int perpage = response.then().extract().path("per_page");
        System.out.println("Per_page value : " +perpage);

        //.data[1].id = 8
        int dataid = response.then().extract().path("data[1].id");
        System.out.println("The value of data id is : " +dataid);

        //.data[3].first_name = Byron
        String firstname = response.then().extract().path("data[3].first_name");
        System.out.println("The value of data first name is : " +firstname);

        //.list of data = 6
        List<String> listofdata = response.then().extract().path("data");
        System.out.println("List of data is : " +listofdata.size());

        //.data[5].avatar="https://reqres.in/img/faces/11-image.jpg"
        String avatar = response.then().extract().path("data[5].avatar");
        System.out.println("The value of avatar is : " + avatar);

        //support.url ="https://reqres.in/#support-heading"
        String supporturl = response.then().extract().path("support.url");
        System.out.println("The value of support url is : " + supporturl);

        //support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
        String supporttext = response.then().extract().path("support.text");
        System.out.println("The value of support txt is : " + supporttext);
    }
}
