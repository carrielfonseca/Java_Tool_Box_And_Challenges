package toolbox;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hostname {

	public static void main(String[] args) {
		System.out.println();
		try {
			String hostName = InetAddress.getLocalHost().getHostName();
			String ipAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println(hostName);
			System.out.println(ipAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
