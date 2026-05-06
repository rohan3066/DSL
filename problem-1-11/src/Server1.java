import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server1 {
    public static void main(String[] args) throws RemoteException {

        try {
            Name_append_imp obj=new Name_append_imp();
            Registry rs= LocateRegistry.createRegistry(1099);
            rs.rebind("Append_Name",obj);
            System.out.println("Server is running............!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }


    }
}
