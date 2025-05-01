import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

public class ReverseClient {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve object reference
            String name = "Reverse";
            Reverse reverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            // Input and call remote method
            System.out.print("Enter String = ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            String result = reverseImpl.reverse_string(str);
            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
