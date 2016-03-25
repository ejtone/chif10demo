package com.ejtone;

/**
 * Created by yuanjing on 16/1/5.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ChifApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(ChifApplication.class, args);
    }

}
