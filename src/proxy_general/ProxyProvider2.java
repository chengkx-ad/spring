package proxy_general;

import java.lang.reflect.*;
import java.util.Arrays;

public class ProxyProvider2 {

    private SmartAnimalable target;

    public ProxyProvider2(SmartAnimalable target) {
        this.target = target;
    }

    public SmartAnimalable getProxy() {

        ClassLoader CL = target.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("方法执行前--日志--方法名--" + method.getName() + "方法开始--参数："
                            + Arrays.asList(args));   // 横切关注点/前置通知
                    result = method.invoke(target, args);
                    System.out.println("方法执行正常结束--日志--方法名--" + method.getName() + "方法结束--结果: result" + result);
                    // 横切关注点/返回通知
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("方法执行出现异常--日志--方法名--" + method.getName()
                            + "异常类型=" + e.getClass().getName());
                    // 这也是一个横切关注点，异常通知
                } finally {
                    // 这也是一个横切关注点，最终通知
                    System.out.println("方法最终结束--日志--方法名-" + method.getName());
                }
                return result;
            }
        };

        SmartAnimalable instance1 = (SmartAnimalable)Proxy.newProxyInstance(CL, interfaces, invocationHandler);
        return instance1;
    }

}
