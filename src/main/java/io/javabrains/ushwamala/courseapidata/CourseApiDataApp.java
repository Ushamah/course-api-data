package io.javabrains.ushwamala.courseapidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CourseApiDataApp {

    public static void main(String[] args) {

        //SpringApplication.run(AppClass.class,args); --> tha AppClass has to be a SpringBootApplication
        //The AppClass has to have a SpringBootApplication annotation
        SpringApplication.run(CourseApiDataApp.class,args);
    }
}
