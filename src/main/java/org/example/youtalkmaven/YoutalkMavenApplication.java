package org.example.youtalkmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class YoutalkMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutalkMavenApplication.class, args);
    }
}
