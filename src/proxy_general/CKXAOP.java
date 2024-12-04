package proxy_general;

/*
* 自己定义一个简单的AOP类
* */

import java.lang.reflect.Method;
import java.util.Arrays;

public class CKXAOP {

    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("方法执行前--日志--方法名--" + method.getName() + "方法开始--参数："
                + Arrays.asList(args));   // 横切关注点/前置通知
    }
}
