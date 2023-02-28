package com.facebook.models;

import lombok.Data;

@Data
public class UserProfileResponse {
    String username;
    String email;
    int id;
    String mobile;
    boolean valid;
}
