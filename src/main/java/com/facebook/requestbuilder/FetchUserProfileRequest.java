package com.facebook.requestbuilder;

import com.facebook.models.UserProfileRequest;
import org.json.JSONObject;

public class FetchUserProfileRequest {

    public JSONObject getUserProfileRequestPayload(String email){
        UserProfileRequest request= UserProfileRequest.builder().email(email).build();
        JSONObject userProfileRequest= new JSONObject(request);
        return userProfileRequest;
    }
}
