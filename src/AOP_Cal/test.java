package AOP_Cal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void calTest(){

        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("bean2.xml");

        cal bean = ioc2.getBean(cal.class);

        bean.cal1(5);
        bean.cal2(5);
    }

}
