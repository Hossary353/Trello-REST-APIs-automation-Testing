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

public class Boards extends Variables{


    RequestSpecification request;

    Response response;
//    idOrganization
    @Given("implementing trello API to create new board in existing workspace")
    public void Create_new_board_in_Organization(){
        RestAssured.baseURI=Base_url+"/1/boards/";

        request = RestAssured.given();



    }
    @When("using POST request with required board creating parameters")
    public void Creating_new_board(){

        request.queryParam("key",userKey).queryParam("token",Token).queryParam("idOrganization",Organization_id).queryParam("name","first-board").header("Content-Type", "application/json");
        response=request.post();
        response.prettyPrint();



        JsonPath path=response.jsonPath();
        Board_id=path.getString("id");
        System.out.println("Board_id = "+Board_id);



    }

    @Then("receive expected board response will result 200 ok")
    public void response_of_created_board(){
        System.out.println("                            board               "+Board_id);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


    @Given("implementing trello API to get all lists on board")
    public void Get_all_lists_on_board(){


        System.out.println("9999999999999999"+Board_id);



        RestAssured.baseURI=Base_url+"/1/boards/"+Board_id+"/lists";
        request=RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token).header("Content-Type", "application/json");

    }

    @When("using GET request to view all existing lists on board")
    public void Get_Requst_for_lists(){
        response=request.get();
        response.prettyPrint();

    }

    @Then("receive expected all list response will result 200 ok")
    public void Get_lists_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);


    }

    ///         /1/boards/{id}
    @Given("implementing trello API to Delete an existing board")
    public void implement_delete_board_api(){

        RestAssured.baseURI=Base_url+"/1/boards/"+Board_id;
        request=RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token);

    }
    @When("using DELETE request to delete an existing board")
    public void DELETE_request_for_aboard(){
        response=request.delete();
        response.prettyPrint();
    }


    @Then("receive expected delete response will result 200 ok")
    public void assert_expected_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }



















}