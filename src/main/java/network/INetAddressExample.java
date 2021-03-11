package network;

import java.net.*;
import java.util.Enumeration;

public class INetAddressExample {

    public static void main(String[] args) {
        // get the network interfaces and associated addresses for this host

        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            while (interfaceList.hasMoreElements()) {
                NetworkInterface iface = interfaceList.nextElement();
                System.out.println("Interface " + iface.getName() + ":");
                Enumeration<InetAddress> addrList = iface.getInetAddresses();
                if (!addrList.hasMoreElements()) {
                    System.out.println("\t(No address for this interface)");
                }
                while (addrList.hasMoreElements()) {
                    InetAddress address = addrList.nextElement();
                    System.out.println(
                            "\tAddress "
                                    + ((address instanceof Inet4Address)
                                            ? "(V4)"
                                            : (address instanceof Inet6Address) ? "(V6)" : "(?)"));
                    System.out.println(": " + address.getHostAddress());
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (String host : args) {
            try {
                System.out.println(host +":");
                InetAddress[] addressList = InetAddress.getAllByName(host);

                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}
