package main.java.org.githubvictorhanxu.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMainApp {
    public static void main(String[] args) {
        //@SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorldBean = context.getBean("myBean", HelloWorld.class);
        helloWorldBean.sayHello();
    }
}
