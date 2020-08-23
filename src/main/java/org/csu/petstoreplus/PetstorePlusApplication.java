package org.csu.petstoreplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.csu.petstoreplus.petstore.mapper")
public class PetstorePlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstorePlusApplication.class, args);
    }

}
