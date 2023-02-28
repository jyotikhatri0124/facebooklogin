package com.facebook.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.HashMap;

public class RestUtils {

    public static Response postRequest(String url, HashMap<String,String> headers,String requestData){
        Response response= RestAssured.given().headers(headers).log().everything().body(requestData).post(url);
        Assert.assertTrue(response.getStatusCode()==200,"Api is throwing error");
        return  response;
    }


}
