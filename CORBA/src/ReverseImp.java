import ReverseApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseImp extends ReversePOA
{
    private ORB orb;

    public void setORB(ORB orb_val)
    {
        orb = orb_val;
    }

    public String reverseString(String str)
    {
        String rev = "";

        for(int i = str.length() - 1; i >= 0; i--)
        {
            rev = rev + str.charAt(i);
        }

        System.out.println("Client Sent : " + str);
        System.out.println("Reversed String : " + rev);

        return rev;
    }
}