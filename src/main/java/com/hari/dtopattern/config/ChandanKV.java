package com.hari.dtopattern.config;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author HariomYadav
 * @since 03/10/20
 */
@Configuration
@ConfigurationProperties(prefix = "chandan")
@Getter
@Setter
public class ChandanKV {
    String key1;
    String key2;
    String key3;

}
