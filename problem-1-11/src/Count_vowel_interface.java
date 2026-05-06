import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Count_vowel_interface extends Remote {
    public int count_vowel(String word) throws RemoteException;
}
