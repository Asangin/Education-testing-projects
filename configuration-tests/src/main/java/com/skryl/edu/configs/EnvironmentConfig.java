package com.skryl.edu.configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:environment.properties")
public interface EnvironmentConfig extends Config{
    @DefaultValue("Local")
    String env();

    @Key("${env}.grpc.host")
    String grpcHost();

    @Key("${env}.postgre.host")
    String postgreHost();

    @Key("${env}.postgre.user.admin")
    String postgreAdminUser();

    @Key("${env}.postgre.user")
    String postgreUser();

    @Key("${env}.postgre.password")
    String postgrePassword();
}