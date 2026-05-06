import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calulator_imp extends UnicastRemoteObject implements Cal_interface {

    protected Calulator_imp() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double power(double a, double b) throws RemoteException {
        return Math.pow(a, b);
    }

    @Override
    public double celsius_to_fer(double a) throws RemoteException {
        return (a * 9/5) + 32;   // FIXED
    }

    @Override
    public double miles_to_klm(double a) throws RemoteException {
        return 1.6*a;
    }

    @Override
    public long factorial(long a) throws RemoteException {
        long res=1;
        for(long i=1;i<=a;i++){
            res*=i;
        }

        return res;
    }
}