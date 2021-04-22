package main.java.org.githubvictorhanxu.examples.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="myBean")
    public HelloWorld getHelloWorld(){
        return new HelloWorld();
    }
}