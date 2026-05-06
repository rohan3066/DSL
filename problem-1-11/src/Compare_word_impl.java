import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Compare_word_impl extends UnicastRemoteObject implements Comapre_word_interface {
    protected Compare_word_impl() throws RemoteException{
        super();
    }

    public String compareStr(String str1,String str2) throws RuntimeException{
        if(str1.compareTo(str2)>0){
                return str1;
        }
        else if(str2.compareTo(str1)>0){
            return str2;
        }  

        return "Both are equal";
      }

}
