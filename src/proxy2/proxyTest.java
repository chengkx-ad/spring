package proxy2;

public class proxyTest {

    public static void main(String[] args) {

        Vehicle vehicle = new car();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);
        Vehicle proxy = vehicleProxyProvider.getProxy();

        System.out.println("proxy 编译类型是 Vehicle");
        System.out.println("运行类型：" + proxy.getClass());
    }

}
