import ReverseApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class ReverseServer
{
    public static void main(String args[])
    {
        try
        {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA
            POA rootpoa = POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            // Create servant
            ReverseImpl reverseImpl = new ReverseImpl();
            reverseImpl.setORB(orb);

            // Get object reference
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(reverseImpl);

            Reverse href = ReverseHelper.narrow(ref);

            // Get naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Bind object reference in naming
            String name = "Reverse";

            NameComponent path[] = ncRef.to_name(name);

            ncRef.rebind(path, href);

            System.out.println("Reverse Server Ready...");

            // Wait for client requests
            orb.run();
        }

        catch(Exception e)
        {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
    }
}