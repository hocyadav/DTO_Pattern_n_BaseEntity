package com.hari.dtopattern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hari.dtopattern.DtoEntity.ViewDTO;
import com.hari.dtopattern.config.ChandanKV;
import com.hari.dtopattern.config.LogConfigDetails;
import com.hari.dtopattern.config.YmlConfig;
import com.hari.dtopattern.dao.OrderDao;
import com.hari.dtopattern.dao.StudentDao;
import com.hari.dtopattern.entity.Order;
import com.hari.dtopattern.entity.Student;
import com.hari.dtopattern.resource.TestConstants;
import lombok.extern.slf4j.Slf4j;
import utils.Constants;

@SpringBootApplication
@Slf4j
public class DtopatternApplication implements CommandLineRunner {

    @Autowired
    ChandanKV chandanKV;

    @Autowired
    LogConfigDetails logConfigDetails;

    @Autowired
    YmlConfig ymlConfig;


    @Autowired
    StudentDao studentDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    TestConstants testConstants;

    @Value(value = "${hari.fullname}")
    String fullName;

    @Value(value = "${hari.lastname}")
    String lastName;

    @Value("any value")
    String anyKey;


    @Value(value = "${key_string}")
    String key1;

    @Value(value = "#{${key_object}}")
    Map<String, String> map;

    public static void main(String[] args) {
        SpringApplication.run(DtopatternApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        readConfigDetails();
        Student student = Student.builder().name("hariom").password("password123").build();
        studentDao.save(student);
        studentDao.save(student);

        Order order = Order.builder().orderName("order hariom").status("active").build();
        orderDao.save(order);

        System.out.println("student = " + student);
        System.out.println("order = " + order);
        ViewDTO viewDTO = ViewDTO.builder().student(Arrays.asList(student)).order(order).build();
        System.out.println("finalDto = " + viewDTO);

        testConstants.foo();
    }

    private void readConfigDetails() {
        System.err.println("DtopatternApplication.run");
        System.out.println("fullName = " + fullName);
        System.out.println("lastName = " + lastName);
        System.out.println("anyKey = " + anyKey);
        System.out.println("key1 = " + key1);
        System.out.println("map = " + map);
        log.info("map = " + map);

        final String key1 = chandanKV.getKey1();
        System.out.println("key1 = " + key1);

        final Map<String, String> application = ymlConfig.getApplication();
        System.out.println("application = " + application);
        final String name = application.get("name");
        System.out.println("application name = " + name);
        final String url = application.get("url");
        System.out.println("application url = " + url);
        final String description = application.get("description");
        System.out.println("application description = " + description);

        final Map<String, List<String>> config = ymlConfig.getConfig();
        System.out.println("config = " + config);

        final Map<String, YmlConfig.Credential> users = ymlConfig.getUsers();
        System.out.println("users = " + users);
        final YmlConfig.Credential root = users.get("root");
        final YmlConfig.Credential guest = users.get("guest");
        System.out.println("root = " + root);
        System.out.println("guest = " + guest);

        final Map<String, YmlConfig.Details> all_users_config = ymlConfig.getAll_users_config();
        System.out.println("all_users_config = " + all_users_config);
        final Set<String> strings = all_users_config.keySet();
        System.out.println("strings = " + strings);
        System.out.println("user1 = " + all_users_config.get("user1"));
        System.out.println("default = " + all_users_config.get("default"));

        final Map<String, Integer> logConfig = ymlConfig.getLogConfig();
        System.out.println("logConfig = " + logConfig);
        System.out.println("logFrequency = " + logConfig.get(Constants.Logs.LOG_FREQUENCY));
        System.out.println("logFrequency = " + logConfig.get(Constants.Logs.LOG_DURATION_IN_SEC));
        System.out.println("logFrequency = " + logConfig.get(Constants.Logs.LOG_WAIT_TIME_IN_SEC));

        final Map<String, Integer> logConfig1 = logConfigDetails.getLogConfig();
        System.out.println("logConfig1 = " + logConfig1);
        final Map<String, LogConfigDetails.LogDetail> userConfig = logConfigDetails.getUserConfig();
        System.out.println("userConfig = " + userConfig);
        final Set<String> strings1 = userConfig.keySet();//list of all users
        System.out.println("strings1 = " + strings1);

    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
