import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TemperatureServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        TemperatureImpl obj = new TemperatureImpl();
        Naming.rebind("rmi://localhost/Temperature", obj);
        System.out.println("Temperature Server Ready");
    }
}