import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        try {
            Registry rs= LocateRegistry.getRegistry("Localhost");
            Count_vowel_interface obj=(Count_vowel_interface) rs.lookup("Count_Vowel");
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter String :");
            String str=sc.next();
            System.out.println("No of vowels is String :"+obj.count_vowel(str));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }


    }
}
