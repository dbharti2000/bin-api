package org.bbc.test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class StepDefs {


    @Steps
    RestClient restClient;

    @When("^I make a post request$")
    public void i_make_a_post_request() throws IOException {
        restClient.makePostRequest();
    }

    @When("^I make a get request$")
    public void i_make_a_get_request() throws IOException {
        restClient.makeGetRequest();
    }

    @Then("^I see status code (\\d+)$")
    public void i_see_status_code(int arg1) {

        assertThat(restClient.getStatusCode(), is(arg1));

    }

    @Then("^I see below response in result:$")
    public void validate_response(Map<String, String> table) {

        String responseBody = restClient.getResponseString();

        JsonPath path = new JsonPath(responseBody).setRoot("headers");


        table.entrySet().forEach(entry -> {
            String actualValue = path.get(entry.getKey());

            String expectedValue = entry.getValue();
            assertTrue("VAlues are not same, expected value" + entry.getValue() + "actual is " + actualValue, actualValue.equalsIgnoreCase(expectedValue));

        });
    }



}


