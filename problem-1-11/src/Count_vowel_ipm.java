import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Count_vowel_ipm extends UnicastRemoteObject implements Count_vowel_interface {
    protected Count_vowel_ipm() throws RemoteException {
        super();
    }

    @Override
    public int count_vowel(String word) throws RemoteException {
        String res=word.toLowerCase();
        int count=0;

        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='a' ||res.charAt(i)=='e'||res.charAt(i)=='i'||res.charAt(i)=='o'||res.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }
}
