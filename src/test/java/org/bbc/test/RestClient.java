package org.bbc.test;//import io.restassured.response.Response;


import org.junit.Test;
import utils.JsonReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class RestClient {

    private String URL ="http://httpbin.org";

    private HashMap<String, String> requestHeaders = new HashMap<String, String>();
    private String requestBody = "{\n" +
            "  \"title\": \"TestTitle\",\n" +
            "  \"body\": \"TestBody\",\n" +
            "  \"userId\": 500,\n" +
            "  \"name\": \"Dheeraj\",\n" +
            "  \"id\": 101\n" +
            "}";
    private String requestURL;
    //private Response response;


    public void makeGetRequest() {
        requestHeaders.put("content-type", "application/json");
        given().headers(requestHeaders).log().all().when().get(URL + "/get");

//        System.out.println("RESPONSE=>>>>>>>>>>>>>" + then().extract().body().jsonPath().get("data.body"));
//        System.out.println("RESPONSE=>>>>>>>>>>>>>" + then().extract().response().asString());
//        System.out.println("RESPONSE=>>>>>>>>>>>>>" + then().extract().statusCode());
////        System.out.println("RESPONSE=>>>>>>>>>>>>>" + then().extract().body().jsonPath().get("data.id"));

    }

    public void makePostRequest() throws IOException {
        requestHeaders.put("content-type", "application/json");
        given().headers(requestHeaders).log().all().body(JsonReader.getJsonBody().toString()).when().post(URL +"/post");
    }


    public String getResponseString() {
        System.out.println("RESPONSE=>>>>>>>>>>>>>" + then().extract().response().asString());

        return then().extract().response().asString();
    }

    public int getStatusCode(){
        return then().extract().statusCode();
    }

    public void assertResponseData(Map<String, String> testData){

    }

}
