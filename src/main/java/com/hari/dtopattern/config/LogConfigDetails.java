package com.hari.dtopattern.config;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author HariomYadav
 * @since 03/10/20
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "log")
@PropertySource("application.yml")//working M1
//@PropertySource("classpath:application.yml")//working M2
//@PropertySource("file:/Users/hariomyadav/Documents/dev/SPRING_BOOT/dtopattern/src/main/resources/application.yml")//working M3
//@PropertySource("application-log.yml")//working M4 - working with different name - will work with classpath , file keyword
//@PropertySource(value = {"application.yml", "application-log.yml"})//working M5, if common property then last file wins, HINTS: make 1st file as default as Parent abstract class
public class LogConfigDetails {
    Map<String, Integer> logConfig;
    Map<String, LogDetail> userConfig;

    @Getter
    @Setter
    @ToString
    public static class LogDetail {//imp - static kw
        String name; //optional
        List<String> logTypes;
    }
}
