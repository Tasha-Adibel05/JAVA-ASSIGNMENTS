import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureImpl extends UnicastRemoteObject implements Temperature {
    public TemperatureImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
}