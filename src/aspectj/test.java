package aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void aspectTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");

        SmartAnimalable bean = ioc.getBean(SmartAnimalable.class);
        float sum = bean.getSum(101.0f, 11.2f);
        System.out.println("sum=" + sum);
        System.out.println("===========");
    }
}
