package stepDefs;

import Global_variables.Variables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Get_board extends Variables {






    Response response;
    RequestSpecification request;

    @Given("implementing trello API to Get existing board in specific work space")
    public void Get_existing_board_in_organization(){

        RestAssured.baseURI=Base_url+"/1/organizations/"+Organization_id+"/boards";
        request= RestAssured.given();

        request.queryParam("key",userKey).queryParam("token",Token).header("Content-Type", "application/json");



    }


    @When("Using GET request with the specified authorization for existing board")
    public void Get_Created_Board(){




        response=request.get();
        response.prettyPrint();
        JsonPath path=response.jsonPath();
        Board_id=path.getString("id[0]");


    }

    @Then("receive created board expected response will result 200 ok")
    public void GET_Board_Response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


}