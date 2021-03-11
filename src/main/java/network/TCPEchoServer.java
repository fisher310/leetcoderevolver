package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPEchoServer {

    // size of receive buffer
    private static final int BUFSIZE = 32;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) throw new IllegalArgumentException("Parameter: <Port>");

        int serverPort = Integer.parseInt(args[0]);

        // Create a server socket to accept client connection requests
        ServerSocket serverSocket = new ServerSocket(serverPort);

        // Size of received message
        int recvMsgSize;
        // Receive buffer
        byte[] receiveBuf = new byte[BUFSIZE];

        // Run forever, accepting and receiving connections.
        while (true) {
            Socket clientSocket = serverSocket.accept();
            SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);

            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            // Receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }
            // Close the socket. We are done with this client！
            clientSocket.close();
        }

        /* NOT REACHED */
    }
}
