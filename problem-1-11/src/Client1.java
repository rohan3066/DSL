import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs= LocateRegistry.getRegistry("Localhost",1099);
        Print_name_interface nameInterface=(Print_name_interface)rs.lookup("Append_Name");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name :");
        String name=sc.next();
        System.out.println(nameInterface.append_name(name));


    }
}
