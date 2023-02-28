package com.facebook.utils;

import com.facebook.BaseClass;
import com.facebook.headers.UserProfileHeaders;
import com.facebook.models.UserProfileResponse;
import com.facebook.requestbuilder.FetchUserProfileRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONObject;


import java.util.HashMap;

public class ApiUtils extends BaseClass {

    private static String USER_PROFILE_END_POINT;
    FetchUserProfileRequest fetchUserProfileRequest;
    HashMap<String,String> headers;
    Response response;
    UserProfileResponse userProfileResponse;

    static {
        USER_PROFILE_END_POINT="http://localhost:8080"+"/user-profile";
    }


    public UserProfileResponse getUserProfileDetails(String email){
        fetchUserProfileRequest=new FetchUserProfileRequest();
        JSONObject payload=fetchUserProfileRequest.getUserProfileRequestPayload(email);
        headers=UserProfileHeaders.createUserProfileRequestHeaders();
        response=RestUtils.postRequest(USER_PROFILE_END_POINT,headers,payload.toString());
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            userProfileResponse=objectMapper.readValue(response.asString(),UserProfileResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return userProfileResponse;
    }


}
