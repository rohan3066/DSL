import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cal_interface extends Remote {
    public int add(int a,int b) throws RemoteException;
    public int sub(int a,int b) throws RemoteException;
    public int multiply(int a,int b) throws RemoteException;
    public int divide(int a,int b) throws RemoteException;
    public double power(double a,double b)throws RemoteException;
    public double celsius_to_fer(double a) throws RemoteException;
    public double miles_to_klm(double a) throws RemoteException;
    public long factorial(long a) throws RemoteException;
}
