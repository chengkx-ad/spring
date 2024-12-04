package proxy_general;

import org.junit.Test;

public class test {
    @Test
    public void smartDogTest(){
        SmartDog smartDog = new SmartDog();
        smartDog.getSum(10.78f, 89.7f);
        smartDog.getSub(10.78f, 89.7f);
    }
}
