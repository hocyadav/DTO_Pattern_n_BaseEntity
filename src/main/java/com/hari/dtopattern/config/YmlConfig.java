package com.hari.dtopattern.config;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HariomYadav
 * @since 03/10/20
 */
@Component
@ConfigurationProperties(prefix = "ymlkey1")//1. root as key
@Getter
@Setter
@ToString
public class YmlConfig {
    Map<String, String> application;
    Map<String, List<String>> config;
    Map<String, Credential> users;//IMP : key as string name , and value as Object(we can create complex DS here)
    Map<String, Details> all_users_config;//IMP : key as string name , and value as Object(we can create complex DS here)

    Map<String, Integer> logConfig;

    @Getter
    @Setter
    @ToString
    public static class Credential {
        String username;
        String password;
    }

    @Getter
    @Setter
    @ToString
    public static class Details {
        Set<String> logType;
        Integer logFrequency;
        Integer logDurationInSec;
        Integer logWaitTimeInSec;
    }

}
