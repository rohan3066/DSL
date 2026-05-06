import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server3 {
    public static void main(String[] args) throws RemoteException{
        try {
                Compare_word_impl obj=new Compare_word_impl();
                Registry rs=LocateRegistry.createRegistry(1099);
                rs.rebind("CompareString", obj);
                System.out.println("Server is running.......!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

}
