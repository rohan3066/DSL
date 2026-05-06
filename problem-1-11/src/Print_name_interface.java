import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Print_name_interface extends Remote {
    String append_name(String name) throws RemoteException;
}
