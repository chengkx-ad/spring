package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.component.UserAction;

public class BeanTest {
    @Test
    public void getBean(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");

        UserAction userAction = ioc.getBean("userAction", UserAction.class);

        System.out.println(userAction);

    }



}
