package main.java.org.githubvictorhanxu.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorldBean = context.getBean("helloWorld", HelloWorld.class);
        helloWorldBean.sayHello();
    }
}
