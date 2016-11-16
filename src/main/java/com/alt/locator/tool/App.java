package com.alt.locator.tool;

import java.util.Enumeration;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

// http://stackoverflow.com/questions/8083479/java-getting-my-ip-address
public class App {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                String name = iface.getDisplayName();
                System.out.print(name + " : ");

                Enumeration ee = iface.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    if (!i.getHostAddress().contains(":")) {
                        System.out.print(i.getHostAddress());
                    }
                }
                System.out.println();
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
