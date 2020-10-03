package com.hari.dtopattern.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import utils.Constants;

/**
 * @author HariomYadav
 * @since 03/10/20
 */
@Component
public class TestConstants {

    @Bean
    public void foo() {
        final int constant1 = Constants.CosmoDb.CONSTANT_1;
        final String fullName = Constants.CosmoDb.Fields.FULL_NAME;
        final String lastName = Constants.CosmoDb.Fields.LAST_NAME;
        System.out.println("constant1 = " + constant1);
        System.out.println("fullName = " + fullName);
        System.out.println("lastName = " + lastName);

        final int globalConstant = Constants.GLOBAL_CONSTANT;
        System.out.println("globalConstant = " + globalConstant);
    }
}
