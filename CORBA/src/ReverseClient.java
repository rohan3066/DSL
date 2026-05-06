import ReverseApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

import java.util.Scanner;

class ReverseClient
{
    public static void main(String args[])
    {
        try
        {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Resolve object reference
            String name = "Reverse";

            Reverse reverseImpl =
                    ReverseHelper.narrow(ncRef.resolve_str(name));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter String : ");

            String str = sc.nextLine();

            String result = reverseImpl.reverseString(str);

            System.out.println("Reversed String : " + result);
        }

        catch(Exception e)
        {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
    }
}