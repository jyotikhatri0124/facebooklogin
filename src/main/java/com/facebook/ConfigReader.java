package com.facebook;


import org.aeonbits.owner.Config;

@Config.Sources({"file:${user.dir}/src/main/resources/application.properties"})
public interface ConfigReader extends Config{
    @Key("facebook_web")
    String facebookWebEndPoint();

    @Key("facebook_login_service")
    String login_service();

}
