package network;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClientTimeout {

    // resend timeout (milliseconds)
    private static final int TIMEOUT = 3000;

    private static final int MAXTRIES = 5;

    public static void main(String[] args) throws IOException {
        if ((args.length < 2 || args.length > 3)) {
            throw new IllegalArgumentException("Parameters: <Server> <Word> [<Port>]");
        }

        InetAddress serverAddress = InetAddress.getByName(args[0]);
        // Convert the argument string to bytes using the default encoding
        byte[] bytesToSend = args[1].getBytes();

        int serverPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        DatagramSocket socket = new DatagramSocket();

        // maximum receive blocking time (milliseconds)
        socket.setSoTimeout(TIMEOUT);

        DatagramPacket sendPacket =
                new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, serverPort);

        DatagramPacket receivePacket =
                new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);

        int tries = 0;

        boolean receivedResponse = false;

        do {
            socket.send(sendPacket);
            try {
                socket.receive(receivePacket);
                // Check source
                if (!receivePacket.getAddress().equals(serverAddress))
                    throw new IOException("Received packet from an unknown source.");
                receivedResponse = true;
            } catch (InterruptedIOException e) {
                tries += 1;
                System.out.println("Timeout, " + (MAXTRIES - tries) + " more tries...");
            }
        } while ((!receivedResponse) && (tries < MAXTRIES));

        if (receivedResponse) {
            System.out.println("Received: " + new String(receivePacket.getData()));
        } else {
            System.out.println("No response -- giving up.");
        }

        socket.close();
    }
}
