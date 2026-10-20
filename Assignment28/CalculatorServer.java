import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        CalculatorImpl obj = new CalculatorImpl();
        Naming.rebind("rmi://localhost/Calculator", obj);
        System.out.println("Calculator Server Ready");
    }
}