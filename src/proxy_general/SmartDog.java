package proxy_general;

public class SmartDog implements SmartAnimalable{
    @Override
    public float getSum(float i, float j) {
        System.out.println("日志--方法名--getSum方法开始--参数：" + i + "," + j);
        float result = i + j;
        System.out.println("方法内部打印：result=" + result);
        System.out.println("日志--方法名--getSum 方法结束--结果: result" + result);
        return result;
    }

    @Override
    public float getSub(float i, float j) {
        System.out.println("日志--方法名--getSub方法开始--参数：" + i + "," + j);
        float result = i - j;
        System.out.println("方法内部打印：result=" + result);
        System.out.println("日志--方法名--getSub 方法结束--结果: result" + result);
        return result;
    }
}
