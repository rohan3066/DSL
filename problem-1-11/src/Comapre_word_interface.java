import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Comapre_word_interface extends Remote {
    String compareStr(String str1,String str2) throws RemoteException;

}
