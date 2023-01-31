package com.cnluminous.ggdtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GgdtoolsApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GgdtoolsApplication.class, args);
        new AutoStart(args);
    }

}
