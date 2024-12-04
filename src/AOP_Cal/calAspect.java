package AOP_Cal;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.After;
import org.springframework.stereotype.Component;

import java.time.temporal.ValueRange;

@Aspect
@Component
public class calAspect{

    @Pointcut(value = "execution(public void AOP_Cal.MyCal.cal1(int))")
    public void myPointCut(){
    }

    @Before(value = "myPointCut()")
    public static void showBeforeLog(JoinPoint joinPoint){
        System.out.println("开始执行计算" + System.currentTimeMillis());
    }

    @AfterReturning(value = "myPointCut()")
    public void showSuccessEndLog(JoinPoint joinPoint){
        System.out.println("结束计算" + System.currentTimeMillis());
    }

    @Pointcut(value = "execution(public void AOP_Cal.MyCal.cal2(int))")
    public void myPointCut2(){
    }

    @Before(value = "myPointCut2()")
    public static void showBeforeLog2(JoinPoint joinPoint){
        System.out.println("开始执行计算" + System.currentTimeMillis());
    }

    @AfterReturning(value = "myPointCut2()")
    public void showSuccessEndLog2(JoinPoint joinPoint){
        System.out.println("结束计算" + System.currentTimeMillis());
    }
}
