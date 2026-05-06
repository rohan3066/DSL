import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Name_append_imp extends UnicastRemoteObject implements Print_name_interface {
    protected Name_append_imp() throws RuntimeException, RemoteException {
        super();
    }

    @Override
    public String append_name(String name) throws RemoteException {
        return "Hello "+name;
    }
}
