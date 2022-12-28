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

public class Lists extends Variables {


    Response response;

    RequestSpecification request;



    @Given("implementing trello API to create new list")
    public void Create_new_list(){


        RestAssured.baseURI=Base_url+"/1/lists";
        request=RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token).queryParam("name","first-list").queryParam("idBoard",Board_id).header("Content-Type", "application/json");







    }

    @When("using POST request to create alist in existing board & organization")
    public void using_Post_to_create_list (){
          System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+Board_id);
        response=request.post();
        JsonPath path=response.jsonPath();
        List_id=path.getString("id");

        response.prettyPrint();
        System.out.println("List_ id = "+List_id);

    }
    @Then("receive expected list response will result 200 ok")
    public void Get_Create_list_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


    @Given("implementing trello API to Archive new workspace")
    public void Implement_necessary_apis_to_archive_list(){
        RestAssured.baseURI=Base_url+"/1/lists/"+List_id+"/closed";
        request=RestAssured.given();
        request.queryParam("key",userKey).queryParam("token",Token).queryParam("value","true").header("Content-Type", "application/json");


    }

    @When("using PUT request to update a status of a list to be archived")
    public void Using_put_request_to_update_status(){



        response=request.put();
        response.prettyPrint();
    }


    @Then("receive expected archive response will result 200 ok")
    public void Get_archive_response(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


}