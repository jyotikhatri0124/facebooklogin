package com.facebook.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileRequest {
    String email;
}


