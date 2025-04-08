import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InternetAvailabilityChecker
{
    public static boolean isInternetAvailable(String Hostname, int port) throws IOException
    {
        return isHostAvailable(Hostname, port);
    }

    private static boolean isHostAvailable(String HostName, int port) throws IOException
    {
        try(Socket socket = new Socket())
        {
            InetSocketAddress socketAddress = new InetSocketAddress(HostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        }
        catch(UnknownHostException unknownHost)
        {
            return false;
        }
    }
    public static void main(String[] args) throws IOException 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String accStr;  

    	System.out.println("Enter website name/ip address : ");
    	accStr = br.readLine();
    	
    	if(isInternetAvailable(accStr,80) == true)
    	{
    		System.out.println("Connection is true");
    	}
    	else
    	{
    		System.out.println("nope");
    	}
    }
}
