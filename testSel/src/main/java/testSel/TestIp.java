package testSel;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class TestIp 
{
	static String[] addressArray=new String[5];
	static String ipAddr=null;
	public static void main(String args[]) throws UnknownHostException, SocketException
	{
		
		String firstInterface = null;        
	    Map<String, String> addressByNetwork = new HashMap<String, String>();
	    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
	    while(networkInterfaces.hasMoreElements())
	    {
	        NetworkInterface network = networkInterfaces.nextElement();
	        byte[] bmac = network.getHardwareAddress();
	        if(bmac != null)
	        {
	        	StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bmac.length; i++)
	            {
	                sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));        
	            }
	            if(sb.toString().isEmpty()==false)
	            {
	                addressByNetwork.put(network.getName(), sb.toString());
//	                System.out.println("Address = "+sb.toString()+" @ ["+network.getName()+"] "+network.getDisplayName());
	            }
	            if(sb.toString().isEmpty()==false && firstInterface == null)
	            {
	                firstInterface = network.getName();
	            }
//	            Enumeration<InetAddress> inetAddresses = network.getInetAddresses();
//	            
//	            for (InetAddress inetAddress : Collections.list(inetAddresses)) 
//	            {
//	                ipAddr=inetAddress.getHostAddress();
//	            }
	        }
	    }
	    addressArray[1]=addressByNetwork.get(firstInterface);
	    addressArray[0]=ipAddr;
	}
}

