import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server2 {
    public static void main(String[] args) throws RemoteException {
        try {
            Count_vowel_ipm obj=new Count_vowel_ipm();
            Registry rs= LocateRegistry.createRegistry(1099);
            rs.rebind("Count_Vowel",obj);
            System.out.println("Server is running .............!");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
