import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client3 {
    public static void main(String[] args) throws RemoteException,NotBoundException{
        Registry rs =LocateRegistry.getRegistry("Localhost");
        Comapre_word_interface obj=(Comapre_word_interface)rs.lookup("CompareString");
        System.out.println(obj.compareStr("rohan", "sid"));
        
    }
}
