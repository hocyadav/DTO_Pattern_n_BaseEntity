# DTO_Pattern_n_BaseEntity
```java
log:
  logConfig:
    logFrequency: 10
    logDurationInSec: 100
    logWaitTimeInSec: 200
  userConfig:
    user-1:
      name: Hariom Yadav
      notificationType:
        - sms
        - email
      logTypes:
        - info
        - blocker
```

```java
@Getter
@Setter
@Component //for autowire
@ConfigurationProperties(prefix = "log")//STEP 1
@PropertySource("application.yml")
public class LogConfigDetails {//Any classs Name, STEP 2 variable name same as yml entries, logConfig userConfig
    Map<String, Integer> logConfig;
    Map<String, LogDetail> userConfig;//Note : minimum 1 entry required in LogDeatils in yml file else app will not start

    @Getter
    @Setter
    public static class LogDetail {
        String name;
        List<String> notificationType;//working M1 for default -> Arrays.asList("sms"), M2 convert String to ENUM
        List<String> logTypes;//working M1
    }
}
```
