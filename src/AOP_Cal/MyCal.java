package AOP_Cal;

import org.springframework.stereotype.Component;

@Component
public class MyCal implements cal{
    @Override
    public void cal1(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res += i;
        }
        System.out.println(res);
    }

    @Override
    public void cal2(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        System.out.println(res);
    }
}
