package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;

public class TCPEchoClient {

    public static void main(String[] args) throws IOException {
        if (args.length < 2 || args.length > 3)
            throw new IllegalArgumentException("Parameters: <Server> <Word> [<Port>]");

        // server name or ip address
        String server = args[0];

        // convert argument String to bytes using the default character encoding
        System.out.println("default charset: " + Charset.defaultCharset().name());
        byte[] data = args[1].getBytes();

        int serverPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        // create socket that is connected to server on specified port

        Socket socket = new Socket(server, serverPort);
        System.out.println("connected to server... sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);

        // Receive the same string back from the server
        // total bytes received so far
        int totalBytesRcvd = 0;

        // Bytes received in last read
        int bytesRcvd;

        while (totalBytesRcvd < data.length) {
            if ((bytesRcvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1)
                throw new SocketException("Connected closed prematurely");
            totalBytesRcvd += bytesRcvd;
        }

        System.out.println("Received: " + new String(data));

        socket.close();
    }
}
