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


public class Organizations extends Variables {

    Response response;
    RequestSpecification request;



    @Given("implementing trello API to create new workspace")
    public void create_workspace () {
        RestAssured.baseURI=Base_url+"/1/organizations";
        request = RestAssured.given();
    }



    @When("Using POST request with the specified authorization")
    public void Create_workspace_usingPOST(){
        request.queryParam("key",userKey).queryParam("token",Token).queryParam("displayName","trello").header("Content-Type", "application/json");

        response  = request.post();


        JsonPath path3 = response.jsonPath();
        Organization_id=path3.getString("id");

        System.out.println("==== Organization ID ========"+Organization_id+"====");
        response.prettyPrint();

    }



    @Then("receive expected response will result 200 ok")
    public void success_response(){


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    //       /1/organizations/{id}

    @Given("implementing trello API to Delete an existing workspace")
    public void implementing_DELETE_request_api(){

        RestAssured.baseURI=Base_url+"/1/organizations/"+Organization_id;
        request=RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token);


    }
    @When("using DELETE request to delete an existing Organization")
    public void using_DELETE_request_for_organization(){
        response=request.delete();
    }
    @Then("receive expected delete workspace response will result 200 ok")
    public void receive_expected_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);


    }





}