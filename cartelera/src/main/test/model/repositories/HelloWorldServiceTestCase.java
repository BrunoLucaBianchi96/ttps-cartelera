package model.repositories;

import model.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class HelloWorldServiceTestCase {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
        String message = helloWorldService.sayHello();
        System.out.println(message);

    }
}
