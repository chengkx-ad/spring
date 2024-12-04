package aspectj;

import org.springframework.stereotype.Component;
import aspectj.SmartAnimalable;


@Component
public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float i, float j) {
        //System.out.println("日志--方法名--getSum方法开始--参数：" + i + "," + j);
        float result = i + j;
        //System.out.println("方法内部打印：result=" + result);
        //System.out.println("日志--方法名--getSum 方法结束--结果: result" + result);
        // result = 1/0; // 为了测试，故意抛出一个异常
        return result;
    }

    @Override
    public float getSub(float i, float j) {
        //System.out.println("日志--方法名--getSub方法开始--参数：" + i + "," + j);
        float result = i - j;
        //System.out.println("方法内部打印：result=" + result);
        //System.out.println("日志--方法名--getSub 方法结束--结果: result" + result);
        return result;
    }
}
