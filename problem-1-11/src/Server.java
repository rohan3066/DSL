import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        try{
            Calulator_imp obj=new Calulator_imp();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("CalculatorService",obj);
            System.out.println("Calculator Server is Ready........!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
