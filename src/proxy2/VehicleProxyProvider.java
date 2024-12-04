package proxy2;

/*
* 动态代理思路：在调用方法时使用反射，根据方法去决定调用哪个对象
* */

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class VehicleProxyProvider {

    private Vehicle target;  // 代理对象

    public VehicleProxyProvider(Vehicle target) {
        this.target = target;
    }

    public Vehicle getProxy() {
        //得到一个类加载处理器
        ClassLoader CL = target.getClass().getClassLoader();

        // 获取接口
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工作开始运行了......");
                Object invoke = method.invoke(target, args);
                System.out.println("交通工具停止运行了......");
                return invoke;
            }
        };

        Vehicle instance = (Vehicle) Proxy.newProxyInstance(CL, interfaces, invocationHandler);
        return instance;
    }

}
