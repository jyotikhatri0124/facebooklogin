package com.facebook.headers;

import com.facebook.constants.HeaderConstants;

import java.util.HashMap;
import java.util.Map;

public class UserProfileHeaders {


    private static HashMap<String,String> headers = new HashMap();

    public final static String Content_Type = "Content-Type";
    public final static String Client_Id = "client-id";
    public final static String Secret_Key = "secret-key";


    public static HashMap<String,String> createUserProfileRequestHeaders(){

        headers.put(Client_Id, HeaderConstants.CLIENT_ID_VALUE);
        headers.put(Secret_Key, HeaderConstants.SECRET_KEY_VALUE);
        headers.put(Content_Type, "application/json");


        return headers;
    }
}
