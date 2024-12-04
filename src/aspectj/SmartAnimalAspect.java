package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 切面类
 */
@Aspect
@Component
public class SmartAnimalAspect {

    // 定义一个切入点
    @Pointcut(value = "public float aspectj.SmartDog.getSum(float, float)")
    public void myPointCut(){};


    // 前置通知
    //@Before(value = "execution(public float aspectj.SmartDog.getSum(float, float))")
    @Before(value = "myPointCut()")
    public static void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("前置通知");
        System.out.println("方法执行前--日志--方法名--" + signature.getName() + "方法开始--参数："
                + Arrays.asList(joinPoint.getArgs()));   // 横切关注点/前置通知
    }

    // 返回通知
    //@AfterReturning(value = "execution(public float aspectj.SmartDog.getSum(float , float))", returning = "res")
    @AfterReturning(value = "myPointCut()", returning = "res")
    public static void showSuccessEndLog(JoinPoint joinPoint, Object res) {
        Signature signature = joinPoint.getSignature();
        System.out.println("返回通知");
        System.out.println("方法执行后--日志--方法名--" + signature.getName() + "方法正常结束");
        System.out.println("返回通知--结束是--" + res);
    }

    @AfterThrowing(value = "execution(public float aspectj.SmartDog.getSum(float , float ))",
    throwing = "throwable")
    public void showExceptionLog(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("异常通知-- 异常信息" + throwable);
    }

    @After(value = "execution(public float aspectj.SmartDog.getSum(float , float ))")
    public void showFinallyEndLog(){
        System.out.println("最终通知");
    }

    //环绕通知（仅作了解即可）
    public Object doAround(ProceedingJoinPoint joinPoint){
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        try {
            Object[] args = joinPoint.getArgs();
            List<Object> list = Arrays.asList(args);
            // 环绕通知---前置通知
            System.out.println("环绕通知---方法执行前--日志--方法名--" + methodName + "方法开始--参数："
                    + list);
            // 环绕通知--返回通知
            result = joinPoint.proceed();
            System.out.println("环绕通知----方法执行后--日志--方法名--" + methodName + "方法正常结束"
                    + "返回通知--结束是--" + result);
        } catch (Throwable e) {
            // 环绕通知--异常通知
            System.out.println("异常通知-- 异常信息" + e);
        } finally {
            // 环绕通知--最终通知
            System.out.println("最终通知");
        }
        return result;
    }
}
