package stepDefs;

import Global_variables.Variables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Members extends Variables {
    public String member_id;

    RequestSpecification request;
    Response response;

    @Given("using GET request to get member id")
    public void get_member_id(){
        RestAssured.baseURI="https://api.trello.com/1/members/me";
        RequestSpecification request2 = RestAssured.given();
        request2.queryParam("key",userKey).queryParam("token",Token);
        Response response1 = request2.get();
        JsonPath path1 = response1.jsonPath();
        response1.prettyPrint();

        member_id= path1.getString("id");
    }

    @When("implementing trello API to Get existing workspace")
    public void Get_workspace(){
        RestAssured.baseURI=Base_url+"/1/members/"+member_id;

        request = RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token).header("Content-Type", "application/json");


    }



    @And("using GET request with specified authorization")
    public void Get_organization(){

        response = request.get();

        response.prettyPrint();
        System.out.println(member_id);
    }

    @Then("receive expected organization response will result 200 ok")
    public void organization_get_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

}