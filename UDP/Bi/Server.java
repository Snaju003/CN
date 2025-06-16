package UDP.Bi;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buffer = new byte[1024];

            DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
            System.out.println("Server waiting for message");

            socket.receive(receivedPacket);
            String clientMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("Message from Client: " + clientMessage);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter response:");
            String ServerMessage = sc.nextLine();
            byte[] serverMessageBuffer = ServerMessage.getBytes();

            InetAddress address = receivedPacket.getAddress();
            int PORT = receivedPacket.getPort();
            DatagramPacket sentPacket = new DatagramPacket(serverMessageBuffer, serverMessageBuffer.length, address,
                    PORT);
            socket.send(sentPacket);

            socket.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
